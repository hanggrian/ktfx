@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.PageRange

/**
 * Create a [PageRange] ranging from [this] to [endPage].
 * @see kotlin.ranges.until
 */
inline infix fun Int.untilPage(endPage: Int): PageRange = PageRange(this, endPage)
