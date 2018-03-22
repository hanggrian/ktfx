package ktfx.styles

import javafx.geometry.Orientation

class ToolBarStyleBuilder : ControlStyleBuilder() {

    var orientation: Orientation by map
}

inline fun toolBarStyle(builder: ToolBarStyleBuilder .() -> Unit): String =
    ToolBarStyleBuilder().apply(builder).toString()