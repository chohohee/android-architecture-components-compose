package com.chh.compose.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
) {

    private fun getIndex(): String = url.split("/".toRegex()).dropLast(1).last()

    fun getImageUrl(): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getIndex()}.png"

    fun getGifUrl(): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/${getIndex()}.gif"

}
