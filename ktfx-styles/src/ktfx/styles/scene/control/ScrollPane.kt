package ktfx.styles

import javafx.scene.control.ScrollPane.ScrollBarPolicy

interface ScrollPaneStyleBuilder {

    var fitToWidth: Boolean

    var fitToHeight: Boolean

    var pannable: Boolean

    var hbarPolicy: ScrollBarPolicy

    var vbarPolicy: ScrollBarPolicy
}

@PublishedApi
@Suppress("ClassName")
internal class _ScrollPaneStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint),
    ScrollPaneStyleBuilder {
    override var fitToWidth: Boolean by map
    override var fitToHeight: Boolean by map
    override var pannable: Boolean by map
    override var hbarPolicy: ScrollBarPolicy by map
    override var vbarPolicy: ScrollBarPolicy by map
}

inline fun scrollPaneStyle(
    prettyPrint: Boolean = false,
    builder: ScrollPaneStyleBuilder .() -> Unit
): String = _ScrollPaneStyleBuilder(prettyPrint).apply(builder).toString()