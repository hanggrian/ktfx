@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.DatePicker
import java.time.LocalDate

inline fun datePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).also { init?.invoke(it) }

inline fun LayoutManager<Node>.datePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = ktfx.layouts.datePicker(date, init).add()