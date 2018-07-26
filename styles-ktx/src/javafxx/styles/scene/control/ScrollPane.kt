package javafxx.styles

import javafx.scene.control.ScrollPane.ScrollBarPolicy
import javafxx.styles.internal._ScrollPaneStyleBuilder

interface ScrollPaneStyleBuilder {

    var fitToWidth: Boolean

    var fitToHeight: Boolean

    var pannable: Boolean

    var hbarPolicy: ScrollBarPolicy

    var vbarPolicy: ScrollBarPolicy
}

inline fun scrollPaneStyle(
    prettyPrint: Boolean = false,
    builder: ScrollPaneStyleBuilder .() -> Unit
): String = _ScrollPaneStyleBuilder(prettyPrint).apply(builder).toString()