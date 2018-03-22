package ktfx.styles

import javafx.geometry.Orientation

class ScrollBarStyleBuilder : ControlStyleBuilder(), OrientableStyleBuilder {

    override var orientation: Orientation by map

    var blockIncrement: Number by map

    var unitIncrement: Number by map
}

inline fun scrollBarStyle(builder: ScrollBarStyleBuilder .() -> Unit): String =
    ScrollBarStyleBuilder().apply(builder).toString()