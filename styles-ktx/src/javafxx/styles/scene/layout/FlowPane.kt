package javafxx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafxx.styles.internal._FlowPaneStyleBuilder

interface FlowPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var columnHalignment: HPos

    var rowValignment: VPos

    var orientation: Orientation
}

inline fun flowPaneStyle(
    prettyPrint: Boolean = false,
    builder: FlowPaneStyleBuilder.() -> Unit
): String = _FlowPaneStyleBuilder(prettyPrint).apply(builder).toString()