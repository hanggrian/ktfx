@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

/** Construct a new position given the added vertical position. */
inline operator fun HPos.plus(vpos: VPos): Pos = posOf(vpos, this)