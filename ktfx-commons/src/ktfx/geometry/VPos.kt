@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

/** Construct a new position given the added horizontal position. */
inline operator fun VPos.plus(hpos: HPos): Pos = posOf(this, hpos)