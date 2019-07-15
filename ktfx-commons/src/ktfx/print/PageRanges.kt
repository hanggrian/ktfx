@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.PageRange

inline infix fun Int.untilPage(endPage: Int): PageRange = PageRange(this, endPage)
