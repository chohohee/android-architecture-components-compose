package com.chh.compose.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.feature.home.HomeScreen

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph() {
    composable<MainTabRoute.Home> {
        HomeScreen()
    }
}
