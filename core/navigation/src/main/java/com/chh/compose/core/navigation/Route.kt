package com.chh.compose.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route

sealed interface MainTabRoute : Route {

    @Serializable
    data object Home : MainTabRoute

}
