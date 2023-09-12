package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.colors.ColorsLexer
import com.deflatedpickle.olio.colors.ColorsParser
import com.deflatedpickle.olio.impl.palette.NamedPalette
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object ColorsReader : PaletteReader {
    override val formatName = "KOffice"
    override val formatExtensions = listOf("colors")

    override fun read(input: InputStream): Palette {
        val lexer = ColorsLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = ColorsParser(tokenStream)

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