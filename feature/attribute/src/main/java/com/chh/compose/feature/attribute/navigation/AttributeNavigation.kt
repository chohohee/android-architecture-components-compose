package com.chh.compose.feature.attribute.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.feature.attribute.AttributeScreen

fun NavController.navigateAttribute(navOptions: NavOptions) {
    navigate(MainTabRoute.Attribute, navOptions)
}

fun NavGraphBuilder.attributeNavGraph() {
    composable<MainTabRoute.Attribute> {
        AttributeScreen()
    }
}
