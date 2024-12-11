package com.chh.compose.core.designsystem.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.kmpalette.palette.graphics.Palette

@Composable
fun Palette?.darkRgbColor(): State<Color> {
    val defaultBackground = MaterialTheme.colorScheme.background.toArgb()
    return remember(this) {
        derivedStateOf {
            val darkVibrant = this?.darkVibrantSwatch?.rgb
            val darkMuted = this?.darkMutedSwatch?.rgb
            val dominant = this?.dominantSwatch?.rgb

            Color(
                listOfNotNull(
                    darkVibrant,
                    darkMuted,
                    dominant,
                    defaultBackground
                ).first()
            )
        }
    }
}
