@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import ktfx.styles.internal._PaginationStyleBuilder

interface PaginationStyleBuilder {

    var maxPageIndicatorCount: Number

    var arrowsVisible: Boolean

    var tooltipVisible: Boolean

    var pageInformationVisible: Boolean

    var pageInformationAlignment: PageAlignment
}

inline fun paginationStyle(
    prettyPrint: Boolean = false,
    builder: PaginationStyleBuilder .() -> Unit
): String = _PaginationStyleBuilder(prettyPrint).apply(builder).toString()