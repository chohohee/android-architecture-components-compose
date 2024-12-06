package com.chh.compose.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.component.NetworkImage
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.model.Pokemon

@Composable
fun PokemonItem(
    item: Pokemon,
    onPokemonClick: (Pokemon) -> Unit
) {
    Column {
        Card(
            shape = RoundedCornerShape(size = 8.dp),
            onClick = { onPokemonClick(item) }
        ) {
            Column {
                NetworkImage(
                    imageUrl = item.getImageUrl(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(17.dp)
                        .aspectRatio(0.9f, true),
                    contentDescription = item.name
                )

                Text(
                    text = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview
@Composable
private fun PokemonItemPreview() {
    AACComposeTheme {
        PokemonItem(
            item = Pokemon(
                name = "bulbasaur",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            ),
            onPokemonClick = {}
        )
    }
}
