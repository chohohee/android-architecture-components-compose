package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.component.ThemePreviews
import com.chh.compose.core.designsystem.theme.AACComposeTheme

@Composable
fun CardDivider(
    index: Int,
    modifier: Modifier = Modifier
) {
    val endOffset = arrayOf((-5).dp, 85.dp)
    val startOffset = if (index % 2 == 0) endOffset else arrayOf(endOffset[1], endOffset[0])
    val backgroundColor = MaterialTheme.colorScheme.background

    Canvas(
        modifier = modifier.aspectRatio(1f)
    ) {
        drawLine(
            color = backgroundColor,
            start = Offset(startOffset[0].toPx(), endOffset[0].toPx()),
            end = Offset(startOffset[1].toPx(), endOffset[1].toPx()),
            strokeWidth = 10.dp.toPx()
        )
    }
}

@ThemePreviews
@Composable
private fun CardDividerPreview() {
    AACComposeTheme {
        CardDivider(index = 0)
    }
}