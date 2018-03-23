package ktfx.styles

import javafx.geometry.Pos

class GridPaneStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var hgap: Number by map

    var vgap: Number by map

    var alignment: Pos by map

    var gridLinesVisible: Boolean by map
}

inline fun gridPaneStyle(
    prettyPrint: Boolean = false,
    builder: GridPaneStyleBuilder.() -> Unit
): String = GridPaneStyleBuilder(prettyPrint).apply(builder).toString()