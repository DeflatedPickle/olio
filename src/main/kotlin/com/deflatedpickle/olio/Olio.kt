package com.deflatedpickle.olio

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.reader.*
import java.io.File
import java.io.IOException

object Olio {
    private val readers = mutableMapOf<String, PaletteReader>()

    init {
        readers["acbl"] = ACBLReader
        // TODO: make a format resolver
        readers["pal"] = JascPalReader
        readers["psppalette"] = JascPalReader
        readers["pal"] = CorelDRAWPalReader
        readers["txt"] = MetaCreationsTXTReader
        readers["hpl"] = HPLReader
        readers["gpl"] = GPLReader
        readers["colors"] = ColorsReader
        readers["spl"] = SPLReader
        readers["skp"] = SKPReader
    }

    fun read(input: File): Palette {
        if (!input.canRead()) throw IOException()
        return readers[input.extension]!!.read(input.inputStream())
    }
}