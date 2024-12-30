package com.chh.compose.core.designsystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.R
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.ImageComponent
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin

@Composable
fun NetworkImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    component: ImageComponent = rememberImageComponent {},
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    previewPainter: Painter? = null
) {
    CoilImage(
        imageModel = { imageUrl },
        modifier = modifier,
        component = component,
        imageOptions = ImageOptions(
            contentScale = contentScale,
            alignment = Alignment.Center,
            contentDescription = contentDescription,
        ),
        previewPlaceholder = previewPainter
    )
}

@ThemePreviews
@Composable
private fun NetworkImagePreview() {
    AACComposeTheme {
        ComposeBackground(
            modifier = Modifier.size(200.dp)
        ) {
            NetworkImage(
                imageUrl = "",
                component = rememberImageComponent {
                    +PlaceholderPlugin.Loading(ColorPainter(Color(0xFF000000)))
                    +PlaceholderPlugin.Failure(ColorPainter(Color(0xFF000000)))
                },
                previewPainter = painterResource(R.drawable.preview_pokemon)
            )
        }
    }
}
