package com.chh.compose.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.chh.compose.core.model.Pokemon
import com.chh.compose.feature.type.navigation.navigateType
import com.chh.compose.feature.pokemon.detail.navigation.navigatePokemonDetail
import com.chh.compose.feature.pokemon.navigation.navigatePokemon

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}

internal class MainNavigator(
    val navController: NavHostController
) {

    val mainTabs = MainTab.entries.toTypedArray()
    val startDestination = MainTab.POKEMON.route

    private val currentDestination: NavDestination?
        @Composable get() =
            navController
                .currentBackStackEntryAsState()
                .value
                ?.destination

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }

    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.POKEMON -> navController.navigatePokemon(navOptions)
            MainTab.TYPE -> navController.navigateType(navOptions)
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigatePokemonDetail(pokemon: Pokemon) {
        navController.navigatePokemonDetail(pokemon)
    }
}
