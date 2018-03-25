package ktfx.styles

import javafx.geometry.Side

interface ChartStyleBuilder {

    var legendSide: Side

    var legendVisible: Boolean

    var titleSide: Side
}

@Suppress("ClassName")
open class _ChartStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), ChartStyleBuilder {
    override var legendSide: Side by map
    override var legendVisible: Boolean by map
    override var titleSide: Side by map
}

inline fun chartStyle(
    prettyPrint: Boolean = false,
    builder: ChartStyleBuilder.() -> Unit
): String = _ChartStyleBuilder(prettyPrint).apply(builder).toString()