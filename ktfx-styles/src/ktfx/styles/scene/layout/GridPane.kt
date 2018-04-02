package ktfx.styles

import javafx.geometry.Pos
import ktfx.styles.internal._GridPaneStyleBuilder

interface GridPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var gridLinesVisible: Boolean
}

inline fun gridPaneStyle(
    prettyPrint: Boolean = false,
    builder: GridPaneStyleBuilder.() -> Unit
): String = _GridPaneStyleBuilder(prettyPrint).apply(builder).toString()