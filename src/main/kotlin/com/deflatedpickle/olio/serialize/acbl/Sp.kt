package com.deflatedpickle.olio.serialize.acbl

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class Sp(
    @SerialName("N") val name: String,
    @SerialName("C") @XmlElement val colour: String,
)
