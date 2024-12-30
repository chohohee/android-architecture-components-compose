package com.chh.compose.feature.pokemon.detail.component

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.chh.compose.core.designsystem.R
import com.chh.compose.core.designsystem.component.ComposeBackground
import com.chh.compose.core.designsystem.component.NetworkImage
import com.chh.compose.core.designsystem.component.ThemePreviews
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.designsystem.theme.PokemonMaterialTheme
import com.chh.compose.core.model.Pokemon
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.ImageComponent
import com.skydoves.landscapist.components.rememberImageComponent
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PokemonDetailHeader(
    pokemon: Pokemon,
    backgroundColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier,
    component: ImageComponent = rememberImageComponent {},
    previewPainter: Painter? = null
) {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    val circleWidth = screenWidthDp / 1.5f
    val radius = circleWidth / 2

    val angle = 45f
    val xOffset = radius * cos(Math.toRadians(angle.toDouble())).toFloat()
    val yOffset = radius * sin(Math.toRadians(angle.toDouble())).toFloat()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NetworkImage(
            imageUrl = pokemon.getImageUrl(),
            modifier = modifier
                .padding(25.dp)
                .size(circleWidth)
                .clip(CircleShape)
                .background(backgroundColor)
                .border(
                    width = 4.dp,
                    color = borderColor,
                    shape = CircleShape
                ),
            component = component,
            previewPainter = previewPainter
        )

        val context = LocalContext.current
        val imageLoader = ImageLoader
            .Builder(context)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        Box(
            modifier = modifier
                .offset(x = xOffset, y = yOffset)
                .size(circleWidth / 4)
                .clip(CircleShape)
                .background(backgroundColor)
                .border(
                    width = 3.dp,
                    color = borderColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            CoilImage(
                imageModel = { pokemon.getGifUrl() },
                modifier = modifier.padding(10.dp),
                imageLoader = { imageLoader },
                previewPlaceholder = previewPainter
            )
        }
    }
}

@ThemePreviews
@Composable
private fun PokemonDetailHeaderPreview() {
    AACComposeTheme {
        ComposeBackground {
            PokemonDetailHeader(
                pokemon = Pokemon(
                    name = "bulbasaur",
                    url = "https://pokeapi.co/api/v2/pokemon/1/"
                ),
                backgroundColor = PokemonMaterialTheme.colorScheme.fire,
                borderColor = PokemonMaterialTheme.colorScheme.electric,
                previewPainter = painterResource(R.drawable.preview_pokemon)
            )
        }
    }
}
