package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.designsystem.theme.PokemonMaterialTheme
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.PokemonInfo.TypeResponse
import com.chh.compose.core.model.Type

@Composable
fun PokemonDetailInfo(
    pokemonInfo: PokemonInfo,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .fillMaxSize()
            .height(80.dp)
            .background(color = backgroundColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "WEIGHT\n" + pokemonInfo.weight,
            modifier = modifier.weight(1f),
            color = Color.White,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        CardDivider(pokemonInfo.types.size)

        Text(
            text = "HEIGHT\n" + pokemonInfo.height,
            modifier = modifier.weight(1f),
            color = Color.White,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(
    widthDp = 400,
    heightDp = 80
)
@Composable
private fun PokemonDetailInfoPreview() {
    AACComposeTheme {
        PokemonDetailInfo(
            pokemonInfo = PokemonInfo(
                id = 1,
                name = "bulbasaur",
                height = 7,
                weight = 69,
                types = listOf(
                    TypeResponse(Type("grass")),
                    TypeResponse(Type("poison"))
                )
            ),
            backgroundColor = PokemonMaterialTheme.colorScheme.dark,
            modifier = Modifier.fillMaxSize()
        )
    }
}

