@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.DatePicker
import java.time.LocalDate

/** Creates a [DatePicker]. */
fun datePicker(
    date: LocalDate? = null,
    init: ((@LayoutDslMarker DatePicker).() -> Unit)? = null
): DatePicker = DatePicker(date).also { init?.invoke(it) }

/** Creates a [DatePicker] and add it to this manager. */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDslMarker DatePicker).() -> Unit)? = null
): DatePicker = ktfx.layouts.datePicker(date, init).add()