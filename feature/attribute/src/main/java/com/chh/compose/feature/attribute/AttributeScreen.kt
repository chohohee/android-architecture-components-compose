package com.chh.compose.feature.attribute

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun AttributeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Attribute",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
