package com.chh.compose.core.navigation

import kotlinx.serialization.Serializable
import com.chh.compose.core.model.Pokemon
import com.chh.compose.core.model.Type

sealed interface Route {

    @Serializable
    data class PokemonDetail(val pokemon: Pokemon) : Route

    @Serializable
    data class TypeDetail(val type: Type) : Route

}

sealed interface MainTabRoute : Route {

    @Serializable
    data object Pokemon : MainTabRoute

    @Serializable
    data object Type : MainTabRoute

    @Serializable
    data object Setting : MainTabRoute

}
