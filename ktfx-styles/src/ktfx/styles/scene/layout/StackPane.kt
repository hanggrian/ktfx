package ktfx.styles

import javafx.geometry.Pos
import ktfx.styles.internal._StackPaneStyleBuilder

interface StackPaneStyleBuilder {

    var alignment: Pos
}

inline fun stackPaneStyle(
    prettyPrint: Boolean = false,
    builder: StackPaneStyleBuilder.() -> Unit
): String = _StackPaneStyleBuilder(prettyPrint).apply(builder).toString()