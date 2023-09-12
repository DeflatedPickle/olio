package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.impl.palette.NamedPalette
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


class SPLReaderTest {
    @Test
    fun `read spl`() {
        val palette = SPLReaderTest::class.java
            .getResource("/mini.spl")?.let {
                SPLReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println((palette as NamedPalette).getNamedSwatch())
    }
}