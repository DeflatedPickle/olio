package com.deflatedpickle.olio.impl.reader

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class JascPalReaderTest {
    @Test
    fun `read jasc pal`() {
        val palette = JascPalReaderTest::class.java
            .getResource("/Automne.pal")?.let {
                JascPalReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println(palette.getSwatch())
    }
}