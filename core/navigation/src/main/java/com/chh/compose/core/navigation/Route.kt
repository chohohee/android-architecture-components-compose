package com.chh.compose.core.navigation

import kotlinx.serialization.Serializable
import com.chh.compose.core.model.Pokemon

sealed interface Route {

    @Serializable
    data class PokemonDetail(val pokemon: Pokemon) : Route

}

sealed interface MainTabRoute : Route {

    @Serializable
    data object Pokemon : MainTabRoute

    @Serializable
    data object Type : MainTabRoute

}
