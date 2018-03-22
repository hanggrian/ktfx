package ktfx.styles

class PaginationStyleBuilder : ControlStyleBuilder() {

    var maxPageIndicatorCount: Number by map

    var arrowsVisible: Boolean by map

    var tooltipVisible: Boolean by map

    var pageInformationVisible: Boolean by map

    var pageInformationAlignment: PageAlignment by map
}

enum class PageAlignment {
    TOP, BOTTOM, LEFT, RIGHT
}

inline fun paginationStyle(builder: PaginationStyleBuilder .() -> Unit): String =
    PaginationStyleBuilder().apply(builder).toString()