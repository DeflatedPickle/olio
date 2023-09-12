package com.deflatedpickle.olio.serialize.skp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("palette")
@Serializable
data class Palette(
    val description: Description,
    val colors: List<Color>
)