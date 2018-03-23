package ktfx.styles

interface LineChartStyleBuilder {

    var createSymbols: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _LineChartStyleBuilder(prettyPrint: Boolean) : _XYChartStyleBuilder(prettyPrint), LineChartStyleBuilder {
    override var createSymbols: Boolean by map
}

inline fun lineChartStyle(
    prettyPrint: Boolean = false,
    builder: LineChartStyleBuilder.() -> Unit
): String = _LineChartStyleBuilder(prettyPrint).apply(builder).toString()