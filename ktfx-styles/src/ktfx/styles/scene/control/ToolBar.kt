package ktfx.styles

import javafx.geometry.Orientation

interface ToolBarStyleBuilder {

    var orientation: Orientation
}

@PublishedApi
@Suppress("ClassName")
internal class _ToolBarStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), ToolBarStyleBuilder {
    override var orientation: Orientation by map
}

inline fun toolBarStyle(
    prettyPrint: Boolean = false,
    builder: ToolBarStyleBuilder .() -> Unit
): String = _ToolBarStyleBuilder(prettyPrint).apply(builder).toString()