package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos

class SeparatorStyleBuilder : ControlStyleBuilder() {

    var orientation: Orientation by map

    var halignment: HPos by map

    var valignment: VPos by map
}

inline fun separatorStyle(builder: SeparatorStyleBuilder .() -> Unit): String =
    SeparatorStyleBuilder().apply(builder).toString()