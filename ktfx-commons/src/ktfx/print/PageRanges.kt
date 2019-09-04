package ktfx.print

import javafx.print.PageRange

infix fun Int.untilPage(endPage: Int): PageRange =
    PageRange(this, endPage)
