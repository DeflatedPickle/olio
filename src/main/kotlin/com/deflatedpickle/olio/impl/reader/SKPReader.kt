package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.deflatedpickle.olio.serialize.skp.Palette as SKPPalette
import com.twelvemonkeys.imageio.color.ColorSpaces
import nl.adaptivity.xmlutil.serialization.XML
import java.awt.Color
import java.io.InputStream

object SKPReader : PaletteReader {
    override val formatName = "sK1"
    override val formatExtensions = listOf("skp")

    override fun read(input: InputStream): Palette {
        val xml = XML.defaultInstance.decodeFromString(
            SKPPalette.serializer(),
            input.reader().readText()
        )

        val map = mutableMapOf<String, Color>()

        for (s in xml.colors) {
            map[s.name] = Color(
                ColorSpaces.getColorSpace(ColorSpaces.CS_GENERIC_CMYK),
                floatArrayOf(
                    s.c,
                    s.m,
                    s.y,
                    s.k,
                ),
                1f
            )
        }

        return NamedPalette(map)
    }
}