package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos

class SeparatorStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map

    var halignment: HPos by map

    var valignment: VPos by map
}

inline fun separatorStyle(
    prettyPrint: Boolean = false,
    builder: SeparatorStyleBuilder .() -> Unit
): String = SeparatorStyleBuilder(prettyPrint).apply(builder).toString()