@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Side

open class _ChartStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), ChartStyleBuilder {
    override var legendSide: Side by map
    override var legendVisible: Boolean by map
    override var titleSide: Side by map
}

interface ChartStyleBuilder {

    var legendSide: Side

    var legendVisible: Boolean

    var titleSide: Side
}

inline fun chartStyle(
    prettyPrint: Boolean = false,
    builder: ChartStyleBuilder.() -> Unit
): String = _ChartStyleBuilder(prettyPrint).apply(builder).toString()