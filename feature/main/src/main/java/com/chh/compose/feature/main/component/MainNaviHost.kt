package com.chh.compose.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import com.chh.compose.feature.type.navigation.typeNavGraph
import com.chh.compose.feature.pokemon.navigation.pokemonNavGraph
import com.chh.compose.feature.main.MainNavigator
import com.chh.compose.feature.pokemon.detail.navigation.pokemonDetailNavGraph
import com.chh.compose.feature.type.detail.navigation.typeDetailNavGraph

@Composable
internal fun MainNaviHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        modifier = modifier.background(color = Color.White)
    ) {

        pokemonNavGraph(
            onPokemonClick = { navigator.navigatePokemonDetail(it) }
        )

        typeNavGraph(
            onTypeClick = { navigator.navigateTypeDetail(it) }
        )

        pokemonDetailNavGraph(
            onUpClick = { navigator.navigateUp() }
        )

        typeDetailNavGraph(
            onUpClick = { navigator.navigateUp() },
            onPokemonClick = { navigator.navigatePokemonDetail(it) }
        )

    }
}