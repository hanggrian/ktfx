package ktfx.styles

open class XYChartStyleBuilder(prettyPrint: Boolean) : ChartStyleBuilder(prettyPrint) {

    var alternativeColumnFillVisible: Boolean by map

    var alternativeRowFillVisible: Boolean by map

    var horizontalGridLinesVisible: Boolean by map

    var horizontalZeroLineVisible: Boolean by map

    var verticalGridLinesVisible: Boolean by map

    var verticalZeroLineVisible: Boolean by map
}

inline fun xyChartStyle(
    prettyPrint: Boolean = false,
    builder: XYChartStyleBuilder.() -> Unit
): String = XYChartStyleBuilder(prettyPrint).apply(builder).toString()