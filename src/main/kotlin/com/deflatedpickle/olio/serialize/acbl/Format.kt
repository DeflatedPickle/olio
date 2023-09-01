package com.deflatedpickle.olio.serialize.acbl

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Format(
    @SerialName("ColorSpace") val colourSpace: String,
    @SerialName("Encoding") val encoding: String,
    @SerialName("Channels") val channels: Int,
    @SerialName("ID") val id: Int,
)
