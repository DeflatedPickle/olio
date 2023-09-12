package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.gpl.GPLLexer
import com.deflatedpickle.olio.gpl.GPLParser
import com.deflatedpickle.olio.impl.palette.NamedPalette
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object GPLReader : PaletteReader {
    override val formatName = "Gimp"
    override val formatExtensions = listOf("gpl")

    override fun read(input: InputStream): Palette {
        val lexer = GPLLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = GPLParser(tokenStream)

        val map = mutableMapOf<String, Color>()

        for (i in parser.start().rgb()) {
            map[i.name().text] = Color(
                i.r.text.toInt(),
                i.g.text.toInt(),
                i.b.text.toInt(),
            )
        }

        return NamedPalette(map)
    }
}