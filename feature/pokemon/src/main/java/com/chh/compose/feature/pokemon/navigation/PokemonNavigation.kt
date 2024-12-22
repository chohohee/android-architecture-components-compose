package com.chh.compose.feature.pokemon.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.feature.pokemon.PokemonScreen

fun NavController.navigatePokemon(navOptions: NavOptions) {
    navigate(MainTabRoute.Pokemon, navOptions)
}

fun NavGraphBuilder.pokemonNavGraph(onPokemonClick: (Pokemon) -> Unit) {
    composable<MainTabRoute.Pokemon> {
        PokemonScreen(
            onPokemonClick = onPokemonClick
        )
    }
}
