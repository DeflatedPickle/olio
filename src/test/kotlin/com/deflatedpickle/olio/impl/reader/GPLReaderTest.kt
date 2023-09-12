package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class GPLReaderTest {
    @Test
    fun `read gpl`() {
        val palette = GPLReaderTest::class.java
            .getResource("/Tango.gpl")?.let {
                GPLReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}