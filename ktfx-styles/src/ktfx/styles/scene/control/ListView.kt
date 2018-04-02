package ktfx.styles

import javafx.geometry.Orientation
import ktfx.styles.internal._ListViewStyleBuilder

interface ListViewStyleBuilder {

    var orientation: Orientation
}

inline fun listViewStyle(
    prettyPrint: Boolean = false,
    builder: ListViewStyleBuilder .() -> Unit
): String = _ListViewStyleBuilder(prettyPrint).apply(builder).toString()