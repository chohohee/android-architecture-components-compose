package com.chh.compose.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.core.navigation.Route

internal enum class MainTab(
    val route: MainTabRoute,
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    HOME(
        MainTabRoute.Home,
        "Home",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    ATTRIBUTE(
        MainTabRoute.Attribute,
        "Attribute",
        Icons.Outlined.Info,
        Icons.Filled.Info
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
