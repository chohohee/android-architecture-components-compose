package com.chh.compose.feature.attribute.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.model.Type

@Composable
fun AttributeItem(
    item: Type
) {
    Text(
        text = item.name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Center,
        maxLines = 1,
        style = MaterialTheme.typography.titleLarge
    )
}

@Preview
@Composable
private fun PokemonItemPreview() {
    AACComposeTheme {
        AttributeItem(
            item = Type(
                name = "normal",
                url = "https://pokeapi.co/api/v2/type/1/"
            )
        )
    }
}
