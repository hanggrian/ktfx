@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.DatePicker
import java.time.LocalDate

inline fun datePicker(
    date: LocalDate? = null
): DatePicker = datePicker(date) { }

inline fun datePicker(
    date: LocalDate? = null,
    init: (@LayoutDsl DatePicker).() -> Unit
): DatePicker = DatePicker(date).apply(init)

inline fun LayoutManager<Node>.datePicker(
    date: LocalDate? = null
): DatePicker = datePicker(date) { }

inline fun LayoutManager<Node>.datePicker(
    date: LocalDate? = null,
    init: (@LayoutDsl DatePicker).() -> Unit
): DatePicker = ktfx.layouts.datePicker(date, init).add()