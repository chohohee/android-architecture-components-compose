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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.chh.compose.core.designsystem.component.NetworkImage
import com.chh.compose.core.model.Pokemon
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.ImageComponent
import com.skydoves.landscapist.components.rememberImageComponent

@Composable
fun PokemonDetailHeader(
    pokemon: Pokemon,
    backgroundColor: Color,
    borderColor: Color,
    component: ImageComponent = rememberImageComponent {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NetworkImage(
            imageUrl = pokemon.getImageUrl(),
            modifier = Modifier
                .padding(25.dp)
                .size(250.dp)
                .clip(CircleShape)
                .background(backgroundColor)
                .border(
                    width = 4.dp,
                    color = borderColor,
                    shape = CircleShape
                ),
            component = component
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
            modifier = Modifier
                .offset {
                    IntOffset(
                        (250.dp.toPx() / density).toInt(),
                        (250.dp.toPx() / density).toInt()
                    )
                }
                .size(83.dp)
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
                modifier = Modifier.padding(10.dp),
                imageLoader = { imageLoader }
            )
        }
    }
}
