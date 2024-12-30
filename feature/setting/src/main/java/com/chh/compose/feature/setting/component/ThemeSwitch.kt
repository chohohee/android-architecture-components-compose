package com.chh.compose.feature.setting.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.R
import com.chh.compose.core.designsystem.component.ComposeBackground
import com.chh.compose.core.designsystem.component.ThemePreviews
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.designsystem.theme.LocalDarkTheme

@Composable
fun ThemeSwitch(
    darkTheme: Boolean,
    onThemeUpdated: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    toggleSize: Dp = 150.dp
) {
    val valueToOffset = if (darkTheme) 1f else 0f
    val offset = remember { Animatable(valueToOffset) }

    LaunchedEffect(darkTheme) {
        if (offset.targetValue != valueToOffset) {
            offset.animateTo(valueToOffset, animationSpec = tween(500))
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (darkTheme) "DARK MODE" else "LIGHT MODE",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(80.dp))

        Box(
            modifier = Modifier
                .width(toggleSize * 2)
                .height(toggleSize)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable { onThemeUpdated.invoke(!darkTheme) }
        ) {
            Box(
                modifier = Modifier
                    .size(toggleSize)
                    .offset {
                        IntOffset((toggleSize * offset.value).roundToPx(), 0)
                    }
                    .padding(10.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )

            Row {
                Box(
                    modifier = Modifier.size(toggleSize),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sunny),
                        contentDescription = "Light Theme",
                        modifier = Modifier.size(toggleSize / 3),
                        tint = if (darkTheme) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.primary
                    )
                }

                Box(
                    modifier = Modifier.size(toggleSize),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.night),
                        contentDescription = "Dark Theme",
                        modifier = Modifier.size(toggleSize / 3),
                        tint = if (darkTheme) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@ThemePreviews
@Composable
private fun ThemeSwitchPreview() {
    AACComposeTheme {
        ComposeBackground {
            ThemeSwitch(
                darkTheme = LocalDarkTheme.current,
                onThemeUpdated = {}
            )
        }
    }
}