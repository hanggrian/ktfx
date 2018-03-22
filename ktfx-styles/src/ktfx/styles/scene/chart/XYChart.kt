package ktfx.styles

open class XYChartStyleBuilder : ChartStyleBuilder() {

    var alternativeColumnFillVisible: Boolean by map

    var alternativeRowFillVisible: Boolean by map

    var horizontalGridLinesVisible: Boolean by map

    var horizontalZeroLineVisible: Boolean by map

    var verticalGridLinesVisible: Boolean by map

    var verticalZeroLineVisible: Boolean by map
}

inline fun xyChartStyle(builder: XYChartStyleBuilder.() -> Unit): String =
    XYChartStyleBuilder().apply(builder).toString()