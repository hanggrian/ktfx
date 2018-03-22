package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos

class FlowPaneStyleBuilder : NodeStyleBuilder(), GappableStyleBuilder, AlignableStyleBuilder, OrientableStyleBuilder {

    override var hgap: Number by map

    override var vgap: Number by map

    override var alignment: Pos by map

    var columnHalignment: HPos by map

    var rowValignment: VPos by map

    override var orientation: Orientation by map
}

inline fun flowPaneStyle(builder: FlowPaneStyleBuilder.() -> Unit): String =
    FlowPaneStyleBuilder().apply(builder).toString()