package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos

class FlowPaneStyleBuilder : RegionStyleBuilder() {

    var hgap: Number by map

    var vgap: Number by map

    var alignment: Pos by map

    var columnHalignment: HPos by map

    var rowValignment: VPos by map

    var orientation: Orientation by map
}

inline fun flowPaneStyle(builder: FlowPaneStyleBuilder.() -> Unit): String =
    FlowPaneStyleBuilder().apply(builder).toString()