package com.chh.compose.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypePokemon(
    @SerialName("pokemon") val pokemon: Pokemon
)