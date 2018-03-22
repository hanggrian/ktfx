package ktfx.styles

import javafx.geometry.Pos

class GridPaneStyleBuilder : RegionStyleBuilder() {

    var hgap: Number by map

    var vgap: Number by map

    var alignment: Pos by map

    var gridLinesVisible: Boolean by map
}

inline fun gridPaneStyle(builder: GridPaneStyleBuilder.() -> Unit): String =
    GridPaneStyleBuilder().apply(builder).toString()