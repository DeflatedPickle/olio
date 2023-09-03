@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.coreldraw.CorelDRAWPalLexer
import com.deflatedpickle.olio.coreldraw.CorelDRAWPalParser
import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.twelvemonkeys.imageio.color.ColorSpaces
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object CorelDRAWPalReader : PaletteReader {
    override val formatName = "CorelDraw 4"
    override val formatExtensions = listOf("pal")

    override fun read(input: InputStream): Palette {
        val lexer = CorelDRAWPalLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = CorelDRAWPalParser(tokenStream)

        val map = mutableMapOf<String, Color>()

        for (i in parser.start().rgb()) {
            map[i.name().text] = Color(
                ColorSpaces.getColorSpace(ColorSpaces.CS_GENERIC_CMYK),
                floatArrayOf(
                    i.INT(0).text.toFloat() / 100,
                    i.INT(1).text.toFloat() / 100,
                    i.INT(2).text.toFloat() / 100,
                    i.INT(3).text.toFloat() / 100,
                ),
                1f
            )
        }

        return NamedPalette(map)
    }
}