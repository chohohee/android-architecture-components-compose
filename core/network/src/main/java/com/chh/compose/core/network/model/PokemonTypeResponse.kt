package com.chh.compose.core.network.model

import com.chh.compose.core.model.TypePokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeResponse(
    @SerialName("pokemon") val pokemon: List<TypePokemon>
)
