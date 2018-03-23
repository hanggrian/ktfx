package ktfx.styles

import javafx.geometry.Orientation

interface ListViewStyleBuilder {

    var orientation: Orientation
}

@PublishedApi
@Suppress("ClassName")
internal class _ListViewStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ListViewStyleBuilder {
    override var orientation: Orientation by map
}

inline fun listViewStyle(
    prettyPrint: Boolean = false,
    builder: ListViewStyleBuilder .() -> Unit
): String = _ListViewStyleBuilder(prettyPrint).apply(builder).toString()