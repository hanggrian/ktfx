@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.PageRange

/** The starting page of the range. */
inline operator fun PageRange.component1(): Int = startPage

/** The ending page of the range. */
inline operator fun PageRange.component2(): Int = endPage