package com.chh.compose.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName(value = "name") val name: String,
    @SerialName(value = "url") val url: String = ""
) {

    fun getType(): Int = url.split("/".toRegex()).dropLast(1).last().toInt()

}
