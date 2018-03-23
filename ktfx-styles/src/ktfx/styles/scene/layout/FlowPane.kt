package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos

class FlowPaneStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var hgap: Number by map

    var vgap: Number by map

    var alignment: Pos by map

    var columnHalignment: HPos by map

    var rowValignment: VPos by map

    var orientation: Orientation by map
}

inline fun flowPaneStyle(
    prettyPrint: Boolean = false,
    builder: FlowPaneStyleBuilder.() -> Unit
): String = FlowPaneStyleBuilder(prettyPrint).apply(builder).toString()