package ktfx.styles

import javafx.scene.control.ScrollPane.ScrollBarPolicy

class ScrollPaneStyleBuilder : ControlStyleBuilder() {

    var fitToWidth: Boolean by map

    var fitToHeight: Boolean by map

    var pannable: Boolean by map

    var hbarPolicy: ScrollBarPolicy by map

    var vbarPolicy: ScrollBarPolicy by map
}

inline fun scrollPaneStyle(builder: ScrollPaneStyleBuilder .() -> Unit): String =
    ScrollPaneStyleBuilder().apply(builder).toString()