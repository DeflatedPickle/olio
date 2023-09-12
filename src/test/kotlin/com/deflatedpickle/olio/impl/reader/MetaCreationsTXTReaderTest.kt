package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MetaCreationsTXTReaderTest {
    @Test
    fun `read metacreations txt`() {
        val palette = MetaCreationsTXTReaderTest::class.java
            .getResource("/PANTONE(R) solid coated.txt")?.let {
                MetaCreationsTXTReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}