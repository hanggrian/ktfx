package ktfx.styles

import javafx.geometry.Pos

class StackPaneStyleBuilder : RegionStyleBuilder() {

    var alignment: Pos by map
}

inline fun stackPaneStyle(builder: StackPaneStyleBuilder.() -> Unit): String =
    StackPaneStyleBuilder().apply(builder).toString()