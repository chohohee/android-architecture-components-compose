package com.chh.compose.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.chh.compose.feature.type.navigation.typeNavGraph
import com.chh.compose.feature.pokemon.navigation.pokemonNavGraph
import com.chh.compose.feature.main.MainNavigator
import com.chh.compose.feature.pokemon.detail.navigation.pokemonDetailNavGraph
import com.chh.compose.feature.setting.navigation.settingNavGraph
import com.chh.compose.feature.type.detail.navigation.typeDetailNavGraph

@Composable
internal fun MainNaviHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    onThemeUpdated: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        modifier = modifier.background(color = MaterialTheme.colorScheme.background)
    ) {

        pokemonNavGraph(
            onPokemonClick = { navigator.navigatePokemonDetail(it) }
        )

        typeNavGraph(
            onTypeClick = { navigator.navigateTypeDetail(it) }
        )

        settingNavGraph(
            onThemeUpdated = onThemeUpdated
        )

        pokemonDetailNavGraph(
            onUpClick = { navigator.navigateUp() },
            onTypeClick = { navigator.navigateTypeDetail(it) }
        )

        typeDetailNavGraph(
            onUpClick = { navigator.navigateUp() },
            onPokemonClick = { navigator.navigatePokemonDetail(it) }
        )

    }
}