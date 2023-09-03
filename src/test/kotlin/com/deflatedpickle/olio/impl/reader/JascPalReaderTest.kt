package com.deflatedpickle.olio.impl.reader

import org.junit.jupiter.api.Test

class JascPalReaderTest {
    @Test
    fun `read jasc pal`() {
        val palette = JascPalReaderTest::class.java
            .getResource("/Automne.pal")?.let { JascPalReader.read(it.openStream()) }

        if (palette != null) {
            println(palette.getSwatch())
        }
    }
}