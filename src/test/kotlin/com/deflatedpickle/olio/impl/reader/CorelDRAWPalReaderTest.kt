package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import org.junit.jupiter.api.Test

class CorelDRAWPalReaderTest {
    @Test
    fun `read coreldraw pal`() {
        val palette = CorelDRAWPalReaderTest::class.java
            .getResource("/TEK140.pal")?.let { CorelDRAWPalReader.read(it.openStream()) }

        if (palette != null) {
            println((palette as NamedPalette).getNamedSwatch())
        }
    }
}