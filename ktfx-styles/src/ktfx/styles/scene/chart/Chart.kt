package ktfx.styles

import javafx.geometry.Side

open class ChartStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var legendSide: Side by map

    var legendVisible: Boolean by map

    var titleSide: Side by map
}

inline fun chartStyle(
    prettyPrint: Boolean = false,
    builder: ChartStyleBuilder.() -> Unit
): String = ChartStyleBuilder(prettyPrint).apply(builder).toString()