package com.deflatedpickle.olio.serialize.skp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("description")
@Serializable
data class Description(
    val type: String,
    val name: String,
)