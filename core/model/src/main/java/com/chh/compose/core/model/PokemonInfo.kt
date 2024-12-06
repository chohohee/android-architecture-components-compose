package com.chh.compose.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfo(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("types") val types: List<TypeResponse>
) {

    @Serializable
    data class TypeResponse(
        @SerialName(value = "type") val type: Type
    )
}
