package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class SKPReaderTest {
    @Test
    fun `read skp`() {
        val palette = SKPReaderTest::class.java
            .getResource("/CMYK_standart.skp")?.let {
                SKPReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}