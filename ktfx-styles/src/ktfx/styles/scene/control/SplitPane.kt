package ktfx.styles

import javafx.geometry.Orientation

class SplitPaneStyleBuilder : ControlStyleBuilder() {

    var orientation: Orientation by map
}

inline fun splitPaneStyle(builder: SplitPaneStyleBuilder .() -> Unit): String =
    SplitPaneStyleBuilder().apply(builder).toString()