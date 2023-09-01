package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.deflatedpickle.olio.serialize.acbl.AdobeSwatchbook
import com.twelvemonkeys.imageio.color.ColorSpaces
import nl.adaptivity.xmlutil.serialization.XML
import java.awt.Color
import java.io.InputStream

object ACBLReader : PaletteReader {
    override val formatName = "Adobe Color Book Legacy"

    override fun read(input: InputStream): Palette {
        val xml = XML.defaultInstance.decodeFromString(
            AdobeSwatchbook.serializer(),
            input.reader().readText()
        )

        val map = mutableMapOf<String, Color>()

        for (s in xml.swatches) {
            map[s.name] = Color(
                ColorSpaces.getColorSpace(ColorSpaces.CS_GENERIC_CMYK),
                s.colour.split(" ").map { it.toFloat() }.toFloatArray(),
                0f
            )
        }

        return NamedPalette(map)
    }
}