@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

/** Returns true if vertical positions matches. */
inline operator fun Pos.contains(vpos: VPos): Boolean = this.vpos == vpos

/** Returns true if horizontal positions matches. */
inline operator fun Pos.contains(hpos: HPos): Boolean = this.hpos == hpos

/**
 * @see HPos.plus
 * @see VPos.plus
 */
@PublishedApi
internal fun mergePos(vpos: VPos, hpos: HPos): Pos {
    val pos = "${vpos}_$hpos"
    return when (pos) {
        "CENTER_CENTER" -> Pos.CENTER
        else -> Pos.valueOf(pos)
    }
}