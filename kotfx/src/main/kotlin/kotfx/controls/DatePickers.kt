@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.DatePicker
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl
import java.time.LocalDate

@JvmOverloads
inline fun datePicker(
        date: LocalDate? = null,
        noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.datePicker(
        date: LocalDate? = null,
        noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.datePicker(
        date: LocalDate? = null,
        noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()