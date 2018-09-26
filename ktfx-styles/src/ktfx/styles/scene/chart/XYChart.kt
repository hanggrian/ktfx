@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

open class _XYChartStyleBuilder(
    prettyPrint: Boolean
) : _ChartStyleBuilder(prettyPrint), XYChartStyleBuilder {
    override var alternativeColumnFillVisible: Boolean by map
    override var alternativeRowFillVisible: Boolean by map
    override var horizontalGridLinesVisible: Boolean by map
    override var horizontalZeroLineVisible: Boolean by map
    override var verticalGridLinesVisible: Boolean by map
    override var verticalZeroLineVisible: Boolean by map
}

interface XYChartStyleBuilder {

    var alternativeColumnFillVisible: Boolean

    var alternativeRowFillVisible: Boolean

    var horizontalGridLinesVisible: Boolean

    var horizontalZeroLineVisible: Boolean

    var verticalGridLinesVisible: Boolean

    var verticalZeroLineVisible: Boolean
}

inline fun xyChartStyle(
    prettyPrint: Boolean = false,
    builder: XYChartStyleBuilder.() -> Unit
): String = _XYChartStyleBuilder(prettyPrint).apply(builder).toString()