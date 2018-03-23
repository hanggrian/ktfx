package ktfx.styles

class PaginationStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var maxPageIndicatorCount: Number by map

    var arrowsVisible: Boolean by map

    var tooltipVisible: Boolean by map

    var pageInformationVisible: Boolean by map

    var pageInformationAlignment: PageAlignment by map
}

enum class PageAlignment {
    TOP, BOTTOM, LEFT, RIGHT
}

inline fun paginationStyle(
    prettyPrint: Boolean = false,
    builder: PaginationStyleBuilder .() -> Unit
): String = PaginationStyleBuilder(prettyPrint).apply(builder).toString()