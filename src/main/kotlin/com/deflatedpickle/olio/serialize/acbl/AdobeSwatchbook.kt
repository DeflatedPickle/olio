@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.serialize.acbl

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlChildrenName
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
data class AdobeSwatchbook(
    @SerialName("Version") val version: Int,
    @SerialName("BookID") val bookID: Int,
    @XmlSerialName("PrefixPostfixPairs") @XmlChildrenName("PrefixPostfixPair") val prefixPostfixPairs: List<PrefixPostfixPair>,
    @SerialName("Formats") @XmlChildrenName("Format") val formats: List<Format>,
    @SerialName("Swatches") @XmlChildrenName("Sp") val swatches: List<Sp>,
)
