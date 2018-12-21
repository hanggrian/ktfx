@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.PageRange

inline infix fun Int.untilPage(end: Int): PageRange = PageRange(this, end)