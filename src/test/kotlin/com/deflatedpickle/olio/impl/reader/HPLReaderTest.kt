package com.deflatedpickle.olio.impl.reader

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class HPLReaderTest {
    @Test
    fun `read jasc pal`() {
        val palette = HPLReaderTest::class.java
            .getResource("/VisiBone1_ap.hpl")?.let {
                HPLReader.read(it.openStream())
            }

        assertNotNull(palette)
        assertTrue { palette.getSwatch().isNotEmpty() }

        println(palette.getSwatch())
    }
}