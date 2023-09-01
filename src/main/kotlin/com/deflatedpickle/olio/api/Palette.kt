package com.deflatedpickle.olio.api

import java.awt.Color

interface Palette {
    fun getSwatch(): Collection<Color>
}