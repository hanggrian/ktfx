package ktfx.styles

interface PieChartStyleBuilder {

    var clockwise: Boolean

    var pieLabelVisible: Boolean

    var labelLineLength: Number

    var startAngle: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _PieChartStyleBuilder(prettyPrint: Boolean) : _ChartStyleBuilder(prettyPrint), PieChartStyleBuilder {
    override var clockwise: Boolean by map
    override var pieLabelVisible: Boolean by map
    override var labelLineLength: Number by map
    override var startAngle: Number by map
}

inline fun pieChartStyle(
    prettyPrint: Boolean = false,
    builder: PieChartStyleBuilder.() -> Unit
): String = _PieChartStyleBuilder(prettyPrint).apply(builder).toString()