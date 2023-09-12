package com.deflatedpickle.olio.serialize.skp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("color")
@Serializable
data class Color(
    val c: Float,
    val m: Float,
    val y: Float,
    val k: Float,
    val name: String
)
