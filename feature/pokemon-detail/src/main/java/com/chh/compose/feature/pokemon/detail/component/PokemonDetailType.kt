package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.component.ComposeBackground
import com.chh.compose.core.designsystem.component.ThemePreviews
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.model.PokemonInfo
import com.chh.compose.core.model.PokemonInfo.TypeResponse
import com.chh.compose.core.model.Type

@Composable
fun PokemonDetailType(
    pokemonInfo: PokemonInfo,
    onTypeClick: (Type) -> Unit,
    modifier: Modifier = Modifier
) {
    pokemonInfo.types.forEachIndexed { index, item ->
        PokemonTypeCard(
            index = index,
            type = item.type,
            onTypeClick = onTypeClick,
            modifier = modifier
        )
    }
}

@ThemePreviews
@Composable
private fun PokemonDetailTypePreview() {
    AACComposeTheme {
        ComposeBackground(
            modifier = Modifier.size(width = 400.dp, height = 80.dp)
        ) {
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
                    ),
                    onTypeClick = {}
                )
            }
        }
    }
}
