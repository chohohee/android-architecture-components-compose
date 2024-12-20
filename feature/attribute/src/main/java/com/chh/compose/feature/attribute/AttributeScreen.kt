package com.chh.compose.feature.attribute

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.designsystem.utils.getPokemonColor
import com.chh.compose.core.designsystem.utils.getPokemonPainter
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.UiState
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun AttributeScreen(
    viewModel: AttributeViewModel = hiltViewModel()
) {
    val attributeUiState by viewModel.attributeUiState.collectAsStateWithLifecycle()

    when (val uiState = attributeUiState) {
        is UiState.Loading -> {
            CircularProgress()
        }

        is UiState.Success -> {
            AttributeContent(uiState.data)
        }

        is UiState.Error -> {
            ErrorView(
                message = uiState.exception.message,
                modifier = Modifier.fillMaxSize(),
                refresh = viewModel.attributeUiState::restart
            )
        }
    }
}

@Composable
internal fun AttributeContent(
    items: List<Type>
) {
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(true) {
        rotation.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 30000,
                    easing = LinearEasing
                ),
            )
        )
    }

    val screenWidthDp: Dp = LocalConfiguration.current.screenWidthDp.dp
    val radius = screenWidthDp / 2f - 30.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .rotate(rotation.value)
    ) {
        items.forEachIndexed { index, type ->
            val angle = 360f / items.size * index
            val xOffset = radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val yOffset = radius * sin(Math.toRadians(angle.toDouble())).toFloat()

            Icon(
                painter = getPokemonPainter(type.name),
                modifier = Modifier
                    .size(50.dp)
                    .offset(x = xOffset, y = yOffset)
                    .clip(CircleShape)
                    .background(getPokemonColor(type.name))
                    .align(Alignment.Center),
                contentDescription = type.name,
                tint = Color.DarkGray
            )
        }
    }
}


@Preview
@Composable
private fun AttributeContentPreview() {
    val list = listOf(
        Type("normal", "https://pokeapi.co/api/v2/type/1/"),
        Type("fighting", "https://pokeapi.co/api/v2/type/2/"),
        Type("flying", "https://pokeapi.co/api/v2/type/3/"),
        Type("poison", "https://pokeapi.co/api/v2/type/4/"),
        Type("ground", "https://pokeapi.co/api/v2/type/5/"),
        Type("rock", "https://pokeapi.co/api/v2/type/6/")
    )
    AACComposeTheme {
        AttributeContent(
            items = list + list + list
        )
    }
}