package ktfx.styles

import javafx.geometry.Orientation
import javafx.geometry.Pos

class TilePaneStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var orientation: Orientation by map

    var prefRows: Int by map

    var prefColumns: Int by map

    var prefTileWidth: Number by map

    var prefTileHeight: Number by map

    var hgap: Number by map

    var vgap: Number by map

    var alignment: Pos by map

    var tileAlignment: Pos by map
}

inline fun tilePaneStyle(
    prettyPrint: Boolean = false,
    builder: TilePaneStyleBuilder.() -> Unit
): String = TilePaneStyleBuilder(prettyPrint).apply(builder).toString()