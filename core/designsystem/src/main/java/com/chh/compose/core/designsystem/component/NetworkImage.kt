package com.chh.compose.core.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
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
) {
    CoilImage(
        imageModel = { imageUrl },
        modifier = modifier,
        component = component,
        imageOptions = ImageOptions(
            contentScale = contentScale,
            alignment = Alignment.Center,
            contentDescription = contentDescription,
        )
    )
}

@Preview
@Composable
private fun NetworkImagePreview() {
    NetworkImage(
        imageUrl = "",
        component = rememberImageComponent {
            +PlaceholderPlugin.Loading(ColorPainter(Color(0xFF000000)))
            +PlaceholderPlugin.Failure(ColorPainter(Color(0xFF000000)))
        }
    )
}
