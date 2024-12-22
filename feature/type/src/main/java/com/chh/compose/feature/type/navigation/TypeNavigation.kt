package com.chh.compose.feature.type.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.feature.type.TypeScreen

fun NavController.navigateType(navOptions: NavOptions) {
    navigate(MainTabRoute.Type, navOptions)
}

fun NavGraphBuilder.typeNavGraph() {
    composable<MainTabRoute.Type> {
        TypeScreen()
    }
}
