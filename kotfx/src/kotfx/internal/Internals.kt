package kotfx.internal

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos

internal const val NO_GETTER: String = "Property does not have a getter"

@PublishedApi
internal fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

@Suppress("NOTHING_TO_INLINE")
internal inline fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let { if (it == "CENTER_CENTER") CENTER else valueOf(it) }