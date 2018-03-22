package ktfx.styles

import javafx.geometry.Orientation

class ListViewStyleBuilder : ControlStyleBuilder(), OrientableStyleBuilder {

    override var orientation: Orientation by map
}

inline fun listViewStyle(builder: ListViewStyleBuilder .() -> Unit): String =
    ListViewStyleBuilder().apply(builder).toString()