package ktfx.styles

import ktfx.styles.internal._LineChartStyleBuilder

interface LineChartStyleBuilder {

    var createSymbols: Boolean
}

inline fun lineChartStyle(
    prettyPrint: Boolean = false,
    builder: LineChartStyleBuilder.() -> Unit
): String = _LineChartStyleBuilder(prettyPrint).apply(builder).toString()