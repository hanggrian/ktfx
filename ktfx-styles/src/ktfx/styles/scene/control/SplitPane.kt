package ktfx.styles

import javafx.geometry.Orientation

interface SplitPaneStyleBuilder {

    var orientation: Orientation
}

@PublishedApi
@Suppress("ClassName")
internal class _SplitPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SplitPaneStyleBuilder {
    override var orientation: Orientation by map
}

inline fun splitPaneStyle(
    prettyPrint: Boolean = false,
    builder: SplitPaneStyleBuilder .() -> Unit
): String = _SplitPaneStyleBuilder(prettyPrint).apply(builder).toString()