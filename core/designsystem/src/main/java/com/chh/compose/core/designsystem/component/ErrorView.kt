package com.chh.compose.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.theme.AACComposeTheme

@Composable
fun ErrorView(
    message: String,
    modifier: Modifier = Modifier,
    refresh: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Button(onClick = refresh) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
private fun ErrorViewPreview() {
    AACComposeTheme {
        ErrorView(
            message = "An error has occurred",
            refresh = {}
        )
    }
}
