package ktfx.print

import javafx.print.PageRange

/**
 * Create a [PageRange] ranging from [this] to [endPage].
 *
 * @see kotlin.ranges.until
 */
infix fun Int.untilPage(endPage: Int): PageRange =
    PageRange(this, endPage)
