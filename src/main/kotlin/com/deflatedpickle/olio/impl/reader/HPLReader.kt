@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.olio.impl.reader

import com.deflatedpickle.olio.api.Palette
import com.deflatedpickle.olio.api.PaletteReader
import com.deflatedpickle.olio.coldfusion.ColdFusionHPLLexer
import com.deflatedpickle.olio.coldfusion.ColdFusionHPLParser
import com.deflatedpickle.olio.impl.palette.UnnamedPalette
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.awt.Color
import java.io.InputStream

object HPLReader : PaletteReader {
    override val formatName = "ColdFusion Studio"
    override val formatExtensions = listOf("hpl")

    override fun read(input: InputStream): Palette {
        val lexer = ColdFusionHPLLexer(CharStreams.fromStream(input))
        val tokenStream = CommonTokenStream(lexer)
        val parser = ColdFusionHPLParser(tokenStream)

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