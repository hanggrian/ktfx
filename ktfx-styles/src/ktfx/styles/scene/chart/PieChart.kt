package ktfx.styles

class PieChartStyleBuilder(prettyPrint: Boolean) : ChartStyleBuilder(prettyPrint) {

    var clockwise: Boolean by map

    var pieLabelVisible: Boolean by map

    var labelLineLength: Number by map

    var startAngle: Number by map
}

inline fun pieChartStyle(
    prettyPrint: Boolean = false,
    builder: PieChartStyleBuilder.() -> Unit
): String = PieChartStyleBuilder(prettyPrint).apply(builder).toString()