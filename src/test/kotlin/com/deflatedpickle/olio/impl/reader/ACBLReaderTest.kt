package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ACBLReaderTest {
    @Test
    fun `read acbl`() {
        val palette = ACBLReaderTest::class.java
            .getResource("/couché.acbl")?.let {
                ACBLReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}