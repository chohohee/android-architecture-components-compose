package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chh.compose.core.model.PokemonInfo

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