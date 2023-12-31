package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CorelDRAWPalReaderTest {
    @Test
    fun `read coreldraw pal`() {
        val palette = CorelDRAWPalReaderTest::class.java
            .getResource("/TEK140.pal")?.let {
                CorelDRAWPalReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}