package com.chh.compose.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName(value = "name") val name: String,
    @SerialName(value = "url") val url: String = ""
)
