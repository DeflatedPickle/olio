package com.deflatedpickle.olio.impl.palette

import com.deflatedpickle.olio.api.Palette
import java.awt.Color

class UnnamedPalette(
    private val colours: List<Color>
) : Palette {
    override fun getSwatch() = colours
}