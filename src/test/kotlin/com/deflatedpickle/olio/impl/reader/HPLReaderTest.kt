package com.deflatedpickle.olio.impl.reader

import org.junit.jupiter.api.Test

class HPLReaderTest {
    @Test
    fun `read jasc pal`() {
        val palette = HPLReaderTest::class.java
            .getResource("/VisiBone1_ap.hpl")?.let { HPLReader.read(it.openStream()) }

        if (palette != null) {
            println(palette.getSwatch())
        }
    }
}