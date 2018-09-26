@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _LineChartStyleBuilder(
    prettyPrint: Boolean
) : _XYChartStyleBuilder(prettyPrint), LineChartStyleBuilder {
    override var createSymbols: Boolean by map
}

interface LineChartStyleBuilder {

    var createSymbols: Boolean
}

inline fun lineChartStyle(
    prettyPrint: Boolean = false,
    builder: LineChartStyleBuilder.() -> Unit
): String = _LineChartStyleBuilder(prettyPrint).apply(builder).toString()