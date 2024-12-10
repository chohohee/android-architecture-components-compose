package com.chh.compose.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import com.chh.compose.feature.home.navigation.homeNavGraph
import com.chh.compose.feature.main.MainNavigator
import com.chh.compose.feature.pokemon.detail.navigation.pokemonDetailNavGraph

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

        homeNavGraph(
            onPokemonClick = { navigator.navigatePokemonDetail(it) }
        )

        pokemonDetailNavGraph(
            onUpClick = { navigator.navigateUp() }
        )

    }
}