package ktfx.internal

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos

object KtFXInternals {

    const val NO_GETTER: String = "Property does not have a getter"

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

    fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let { if (it == "CENTER_CENTER") CENTER else valueOf(it) }
}