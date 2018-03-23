package ktfx.styles

import javafx.geometry.Orientation

class ListViewStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map
}

inline fun listViewStyle(
    prettyPrint: Boolean = false,
    builder: ListViewStyleBuilder .() -> Unit
): String = ListViewStyleBuilder(prettyPrint).apply(builder).toString()