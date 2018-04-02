package ktfx.styles

import javafx.geometry.Orientation
import ktfx.styles.internal._SplitPaneStyleBuilder

interface SplitPaneStyleBuilder {

    var orientation: Orientation
}

inline fun splitPaneStyle(
    prettyPrint: Boolean = false,
    builder: SplitPaneStyleBuilder .() -> Unit
): String = _SplitPaneStyleBuilder(prettyPrint).apply(builder).toString()