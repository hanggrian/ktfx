package ktfx.styles

import javafx.geometry.Orientation

class ToolBarStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map
}

inline fun toolBarStyle(
    prettyPrint: Boolean = false,
    builder: ToolBarStyleBuilder .() -> Unit
): String = ToolBarStyleBuilder(prettyPrint).apply(builder).toString()