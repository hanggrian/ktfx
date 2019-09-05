@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker

/** Add a [DatePicker] to this manager. */
fun NodeManager.datePicker(
    date: LocalDate? = null
): DatePicker = DatePicker(date).add()

/** Add a [DatePicker] with initialization block to this manager. */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker = datePicker(date).apply(init)
