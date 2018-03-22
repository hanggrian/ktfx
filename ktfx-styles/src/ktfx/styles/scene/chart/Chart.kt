package ktfx.styles

import javafx.geometry.Side

open class ChartStyleBuilder : RegionStyleBuilder() {

    var legendSide: Side by map

    var legendVisible: Boolean by map

    var titleSide: Side by map
}

inline fun chartStyle(builder: ChartStyleBuilder.() -> Unit): String =
    ChartStyleBuilder().apply(builder).toString()