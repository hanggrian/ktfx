@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Creates a [DatePicker]. */
fun datePicker(
    date: LocalDate? = null,
    init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).also {
    init?.invoke(it)
}

/** Creates a [DatePicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.datePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = ktfx.layouts.datePicker(date, init)()

/** Create a styled [DatePicker]. */
fun styledDatePicker(
    styleClass: String,
    date: LocalDate? = null,
    init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [DatePicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledDatePicker(
    styleClass: String,
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = ktfx.layouts.styledDatePicker(styleClass, date, init)()