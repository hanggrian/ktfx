package ktfx.styles

class LineChartStyleBuilder : XYChartStyleBuilder() {

    var createSymbols: Boolean by map
}

inline fun lineChartStyle(builder: LineChartStyleBuilder.() -> Unit): String =
    LineChartStyleBuilder().apply(builder).toString()