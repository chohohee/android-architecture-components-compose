package com.chh.compose.feature.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chh.compose.core.navigation.MainTabRoute
import com.chh.compose.feature.setting.SettingScreen

fun NavController.navigateSetting(navOptions: NavOptions) {
    navigate(MainTabRoute.Setting, navOptions)
}

fun NavGraphBuilder.settingNavGraph() {
    composable<MainTabRoute.Setting> {
        SettingScreen()
    }
}
