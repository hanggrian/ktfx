package ktfx.styles

import javafx.geometry.Orientation

class ScrollBarStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map

    var blockIncrement: Number by map

    var unitIncrement: Number by map
}

inline fun scrollBarStyle(
    prettyPrint: Boolean = false,
    builder: ScrollBarStyleBuilder .() -> Unit
): String = ScrollBarStyleBuilder(prettyPrint).apply(builder).toString()