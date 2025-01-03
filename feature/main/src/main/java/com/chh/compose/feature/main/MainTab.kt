package com.chh.compose.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
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
    POKEMON(
        MainTabRoute.Pokemon,
        "Pokemon",
        Icons.Outlined.Home,
        Icons.Filled.Home
    ),
    TYPE(
        MainTabRoute.Type,
        "Type",
        Icons.Outlined.Info,
        Icons.Filled.Info
    ),
    SETTING(
        MainTabRoute.Setting,
        "Setting",
        Icons.Outlined.Settings,
        Icons.Filled.Settings
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
