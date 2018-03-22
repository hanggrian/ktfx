package ktfx.styles

import javafx.geometry.Orientation
import javafx.geometry.Pos

class TilePaneStyleBuilder : NodeStyleBuilder(), OrientableStyleBuilder, GappableStyleBuilder, AlignableStyleBuilder {

    override var orientation: Orientation by map

    var prefRows: Int by map

    var prefColumns: Int by map

    var prefTileWidth: Number by map

    var prefTileHeight: Number by map

    override var hgap: Number by map

    override var vgap: Number by map

    override var alignment: Pos by map

    var tileAlignment: Pos by map
}

inline fun tilePaneStyle(builder: TilePaneStyleBuilder.() -> Unit): String =
    TilePaneStyleBuilder().apply(builder).toString()