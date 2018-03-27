@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos

/** Construct a new position given the added horizontal position. */
operator fun VPos.plus(hpos: HPos): Pos = "${this}_$hpos".let {
    if (it == "CENTER_CENTER") CENTER else valueOf(it)
}