@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.DatePicker
import kotfx.ChildManager
import kotfx.internal.ControlDsl
import java.time.LocalDate

@JvmOverloads
inline fun datePicker(
        date: LocalDate? = null,
        noinline init: ((@ControlDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.datePicker(
        date: LocalDate? = null,
        noinline init: ((@ControlDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()