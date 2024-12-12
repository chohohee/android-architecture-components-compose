package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.PokemonInfo.TypeResponse
import com.chh.compose.core.model.Type

@Composable
fun PokemonDetailType(
    pokemonInfo: PokemonInfo,
    modifier: Modifier = Modifier
) {
    pokemonInfo.types.forEachIndexed { index, item ->
        PokemonTypeCard(
            index = index,
            type = item.type.name,
            modifier = modifier
        )
    }
}

@Preview(
    widthDp = 400,
    heightDp = 80
)
@Composable
private fun PokemonDetailTypePreview() {
    AACComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            PokemonDetailType(
                pokemonInfo = PokemonInfo(
                    id = 1,
                    name = "bulbasaur",
                    height = 7,
                    weight = 69,
                    types = listOf(TypeResponse(Type("grass")))
                )
            )
        }
    }
}
