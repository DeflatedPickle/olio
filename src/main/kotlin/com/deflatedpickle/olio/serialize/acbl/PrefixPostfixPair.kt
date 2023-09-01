package com.deflatedpickle.olio.serialize.acbl

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrefixPostfixPair (
    @SerialName("ID") val id: String = "",
    @SerialName("Prefix") val prefix: String,
    @SerialName("Postfix") val postfix: String,
)
