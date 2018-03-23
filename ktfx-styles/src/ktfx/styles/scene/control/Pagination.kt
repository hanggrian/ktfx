package ktfx.styles

interface PaginationStyleBuilder {

    var maxPageIndicatorCount: Number

    var arrowsVisible: Boolean

    var tooltipVisible: Boolean

    var pageInformationVisible: Boolean

    var pageInformationAlignment: PageAlignment
}

@PublishedApi
@Suppress("ClassName")
internal class _PaginationStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint),
    PaginationStyleBuilder {
    override var maxPageIndicatorCount: Number by map
    override var arrowsVisible: Boolean by map
    override var tooltipVisible: Boolean by map
    override var pageInformationVisible: Boolean by map
    override var pageInformationAlignment: PageAlignment by map
}

enum class PageAlignment {
    TOP, BOTTOM, LEFT, RIGHT
}

inline fun paginationStyle(
    prettyPrint: Boolean = false,
    builder: PaginationStyleBuilder .() -> Unit
): String = _PaginationStyleBuilder(prettyPrint).apply(builder).toString()