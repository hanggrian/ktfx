package ktfx.styles

import ktfx.styles.internal._PieChartStyleBuilder

interface PieChartStyleBuilder {

    var clockwise: Boolean

    var pieLabelVisible: Boolean

    var labelLineLength: Number

    var startAngle: Number
}

inline fun pieChartStyle(
    prettyPrint: Boolean = false,
    builder: PieChartStyleBuilder.() -> Unit
): String = _PieChartStyleBuilder(prettyPrint).apply(builder).toString()