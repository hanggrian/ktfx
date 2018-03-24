@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos

/** The vertical positioning/alignment. */
inline operator fun Pos.component1(): VPos = vpos

/** The horizontal positioning/alignment. */
inline operator fun Pos.component2(): HPos = hpos

@PublishedApi
internal fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
    if (it == "CENTER_CENTER") CENTER else valueOf(it)
}