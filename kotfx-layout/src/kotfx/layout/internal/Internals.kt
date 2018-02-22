package kotfx.layout.internal

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos

@Suppress("NOTHING_TO_INLINE")
internal inline fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let { if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it) }