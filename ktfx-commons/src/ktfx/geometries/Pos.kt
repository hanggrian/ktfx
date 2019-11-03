@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

/** Returns true if vertical positions matches. */
inline operator fun Pos.contains(vpos: VPos): Boolean =
    this.vpos == vpos

/** Returns true if horizontal positions matches. */
inline operator fun Pos.contains(hpos: HPos): Boolean =
    this.hpos == hpos

/** Construct a new position given the added vertical position. */
operator fun HPos.plus(vpos: VPos): Pos =
    mergePos(vpos, this)

/** Construct a new position given the added horizontal position. */
operator fun VPos.plus(hpos: HPos): Pos =
    mergePos(this, hpos)

/**
 * @see HPos.plus
 * @see VPos.plus
 */
private fun mergePos(vpos: VPos, hpos: HPos): Pos = when (val pos = "${vpos}_$hpos") {
    "CENTER_CENTER" -> Pos.CENTER
    else -> Pos.valueOf(pos)
}
