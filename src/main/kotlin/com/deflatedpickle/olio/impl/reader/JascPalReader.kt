@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.jasc.JascPalLexer
import com.deflatedpickle.olio.jasc.JascPalParser
import com.deflatedpickle.olio.impl.palette.UnnamedPalette
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object JascPalReader : PaletteReader {
    override val formatName = "Jasc Paint Shop Pro"
    override val formatExtensions = listOf("pal", "psppalette")

    override fun read(input: InputStream): Palette {
        val lexer = JascPalLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = JascPalParser(tokenStream)

        val list = mutableListOf<Color>()

        for (i in parser.start().rgb()) {
            list.add(
                Color(
                    i.INT(0).text.toInt(),
                    i.INT(1).text.toInt(),
                    i.INT(2).text.toInt(),
                )
            )
        }

        return UnnamedPalette(list)
    }
}