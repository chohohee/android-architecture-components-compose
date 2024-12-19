package com.chh.compose.core.network.model

import com.chh.compose.core.model.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeResponse(
    @SerialName("results") val results: List<Type>
)
