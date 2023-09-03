package com.deflatedpickle.olio.api

import java.io.InputStream

interface PaletteReader {
    val formatName: String
    val formatExtensions: List<String>

    fun read(input: InputStream): Palette
}