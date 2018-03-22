package ktfx.styles

class PieChartStyleBuilder : ChartStyleBuilder() {

    var clockwise: Boolean by map

    var pieLabelVisible: Boolean by map

    var labelLineLength: Number by map

    var startAngle: Number by map
}

inline fun pieChartStyle(builder: PieChartStyleBuilder.() -> Unit): String =
    PieChartStyleBuilder().apply(builder).toString()