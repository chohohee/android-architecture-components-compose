package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.component.NetworkImage
import com.chh.compose.core.designsystem.component.darkRgbColor
import com.chh.compose.core.designsystem.component.lightRgbColor
import com.chh.compose.core.model.Pokemon
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.palette.PalettePlugin
import com.skydoves.landscapist.palette.rememberPaletteState

@Composable
fun PokemonDetailHeader(pokemon: Pokemon) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var palette by rememberPaletteState(null)
        val lightRgbColor by palette.lightRgbColor()
        val darkRgbColor by palette.darkRgbColor()

        NetworkImage(
            imageUrl = pokemon.getImageUrl(),
            modifier = Modifier
                .padding(25.dp)
                .size(250.dp)
                .clip(CircleShape)
                .background(lightRgbColor)
                .border(
                    width = 4.dp,
                    color = darkRgbColor,
                    shape = CircleShape
                ),
            component = rememberImageComponent {
                +PalettePlugin { palette = it }
            }
        )
    }
}
