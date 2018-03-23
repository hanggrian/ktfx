package ktfx.styles

class LineChartStyleBuilder(prettyPrint: Boolean) : XYChartStyleBuilder(prettyPrint) {

    var createSymbols: Boolean by map
}

inline fun lineChartStyle(
    prettyPrint: Boolean = false,
    builder: LineChartStyleBuilder.() -> Unit
): String = LineChartStyleBuilder(prettyPrint).apply(builder).toString()