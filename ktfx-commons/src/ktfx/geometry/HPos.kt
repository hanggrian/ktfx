@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import ktfx.internal.KtFXInternals.posOf

/** Construct a new position given the added vertical position. */
operator fun HPos.plus(vpos: VPos): Pos = posOf(vpos, this)