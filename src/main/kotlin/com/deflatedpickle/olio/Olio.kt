package com.deflatedpickle.olio

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.api.PaletteWriter
import com.deflatedpickle.olio.impl.reader.ACBLReader
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.URL

object Olio {
    internal val readers = mutableMapOf<String, PaletteReader>()

    init {
        readers["acbl"] = ACBLReader
    }

    fun read(input: File): Palette {
        if (!input.canRead()) throw IOException()
        return readers[input.extension]!!.read(input.inputStream())
    }
}