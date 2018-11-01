@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.DatePicker
import ktfx.NodeManager
import ktfx.LayoutDsl
import java.time.LocalDate

/** Creates a [DatePicker]. */
fun datePicker(
    date: LocalDate? = null,
    init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).also { init?.invoke(it) }

/** Creates a [DatePicker] and add it to this manager. */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null
): DatePicker = ktfx.layouts.datePicker(date, init)()