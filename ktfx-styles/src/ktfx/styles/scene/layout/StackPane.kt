package ktfx.styles

import javafx.geometry.Pos

class StackPaneStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var alignment: Pos by map
}

inline fun stackPaneStyle(
    prettyPrint: Boolean = false,
    builder: StackPaneStyleBuilder.() -> Unit
): String = StackPaneStyleBuilder(prettyPrint).apply(builder).toString()