package com.chh.compose.feature.pokemon.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.navigation.Route
import com.chh.compose.core.navigation.type.PokemonType
import com.chh.compose.feature.pokemon.detail.PokemonDetailScreen
import kotlin.reflect.typeOf

fun NavController.navigatePokemonDetail(pokemon: Pokemon) {
    navigate(Route.PokemonDetail(pokemon))
}

fun NavGraphBuilder.pokemonDetailNavGraph(onUpClick: () -> Unit) {
    composable<Route.PokemonDetail>(
        typeMap = mapOf(typeOf<Pokemon>() to PokemonType)
    ) {
        PokemonDetailScreen(
            onUpClick = onUpClick
        )
    }
}
