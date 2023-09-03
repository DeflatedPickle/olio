package com.deflatedpickle.olio.impl.palette

import com.deflatedpickle.olio.api.Palette
import java.awt.Color

class NamedPalette(
    private val colours: Map<String, Color>
) : Palette {
    override fun getSwatch() = colours.values
    fun getNamedSwatch() = colours
}