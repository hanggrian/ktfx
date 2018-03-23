package ktfx.styles

import javafx.geometry.Orientation

interface ScrollBarStyleBuilder {

    var orientation: Orientation

    var blockIncrement: Number

    var unitIncrement: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _ScrollBarStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), ScrollBarStyleBuilder {
    override var orientation: Orientation by map
    override var blockIncrement: Number by map
    override var unitIncrement: Number by map
}

inline fun scrollBarStyle(
    prettyPrint: Boolean = false,
    builder: ScrollBarStyleBuilder .() -> Unit
): String = _ScrollBarStyleBuilder(prettyPrint).apply(builder).toString()