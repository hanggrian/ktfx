package ktfx.styles

import javafx.geometry.Orientation

class ToolBarStyleBuilder : ControlStyleBuilder(), OrientableStyleBuilder {

    override var orientation: Orientation by map
}

inline fun toolBarStyle(builder: ToolBarStyleBuilder .() -> Unit): String =
    ToolBarStyleBuilder().apply(builder).toString()