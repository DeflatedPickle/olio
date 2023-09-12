@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.impl.palette.NamedPalette
import com.deflatedpickle.olio.spl.SPLLexer
import com.deflatedpickle.olio.spl.SPLParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object SPLReader : PaletteReader {
    override val formatName = "Skencil"
    override val formatExtensions = listOf("spl")

    override fun read(input: InputStream): Palette {
        val lexer = SPLLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = SPLParser(tokenStream)

        val map = mutableMapOf<String, Color>()

        for (i in parser.start().rgb()) {
            map[i.name().text] = Color(
                i.r.text.toFloat(),
                i.g.text.toFloat(),
                i.b.text.toFloat(),
            )
        }

        return NamedPalette(map)
    }
}