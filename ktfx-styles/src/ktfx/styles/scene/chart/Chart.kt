package ktfx.styles

import javafx.geometry.Side
import ktfx.styles.internal._ChartStyleBuilder

interface ChartStyleBuilder {

    var legendSide: Side

    var legendVisible: Boolean

    var titleSide: Side
}

inline fun chartStyle(
    prettyPrint: Boolean = false,
    builder: ChartStyleBuilder.() -> Unit
): String = _ChartStyleBuilder(prettyPrint).apply(builder).toString()