package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MetaCreationsTXTReaderTest {
    @Test
    fun `read metacreations txt`() {
        val palette = MetaCreationsTXTReaderTest::class.java
            .getResource("/PANTONE(R) solid coated.txt")?.let { MetaCreationsTXTReader.read(it.openStream()) }

        if (palette != null) {
            println((palette as NamedPalette).getNamedSwatch())
        }
    }
}