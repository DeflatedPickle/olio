package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.deflatedpickle.olio.metacreations.MetaCreationsTXTLexer
import com.deflatedpickle.olio.metacreations.MetaCreationsTXTParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object MetaCreationsTXTReader : PaletteReader {
    override val formatName = "MetaCreations Painter"
    override val formatExtensions = listOf("txt")

    override fun read(input: InputStream): Palette {
        val lexer = MetaCreationsTXTLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = MetaCreationsTXTParser(tokenStream)

        val map = mutableMapOf<String, Color>()

        for (i in parser.start().line()) {
            map[i.name().text] = Color(
                i.INT(0).text.toInt(),
                i.INT(1).text.toInt(),
                i.INT(2).text.toInt(),
            )
        }

        return NamedPalette(map)
    }
}