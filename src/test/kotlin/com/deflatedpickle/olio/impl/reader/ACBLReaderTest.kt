package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.deflatedpickle.olio.serialize.acbl.AdobeSwatchbookTest
import kotlin.test.Test

class ACBLReaderTest {
    @Test
    fun `read acbl`() {
        val palette = ACBLReaderTest::class.java
            .getResource("/couché.acbl")?.let { ACBLReader.read(it.openStream()) }

        if (palette != null) {
            println((palette as NamedPalette).getNamedSwatch())
        }
    }
}