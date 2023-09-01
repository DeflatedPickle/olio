@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.serialize.acbl

import nl.adaptivity.xmlutil.serialization.XML
import kotlin.test.Test

internal class AdobeSwatchbookTest {
    @Test
    fun `decode acbl`() {
        AdobeSwatchbookTest::class.java
            .getResource("/couché.acbl")?.let {
                XML.defaultInstance.decodeFromString(
                    AdobeSwatchbook.serializer(),
                    it.readText()
                )
            }
    }
}