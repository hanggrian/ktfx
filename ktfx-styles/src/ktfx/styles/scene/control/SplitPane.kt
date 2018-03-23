package ktfx.styles

import javafx.geometry.Orientation

class SplitPaneStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map
}

inline fun splitPaneStyle(
    prettyPrint: Boolean = false,
    builder: SplitPaneStyleBuilder .() -> Unit
): String = SplitPaneStyleBuilder(prettyPrint).apply(builder).toString()