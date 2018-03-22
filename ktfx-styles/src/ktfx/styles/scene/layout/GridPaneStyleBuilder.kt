package ktfx.styles

import javafx.geometry.Pos

class GridPaneStyleBuilder : NodeStyleBuilder(), GappableStyleBuilder, AlignableStyleBuilder {

    override var hgap: Number by map

    override var vgap: Number by map

    override var alignment: Pos by map

    var gridLinesVisible: Boolean by map
}

inline fun gridPaneStyle(builder: GridPaneStyleBuilder.() -> Unit): String =
    GridPaneStyleBuilder().apply(builder).toString()