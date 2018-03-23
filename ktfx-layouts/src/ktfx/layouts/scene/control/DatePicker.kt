@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.DatePicker
import java.time.LocalDate

inline fun datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }
inline fun ChildManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()
inline fun ItemManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()
inline fun ButtonManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()