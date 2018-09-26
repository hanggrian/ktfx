@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _PaginationStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), PaginationStyleBuilder {
    override var maxPageIndicatorCount: Number by map
    override var arrowsVisible: Boolean by map
    override var tooltipVisible: Boolean by map
    override var pageInformationVisible: Boolean by map
    override var pageInformationAlignment: PageAlignment by map
}

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