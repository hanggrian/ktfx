@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker

/** Create a [DatePicker] with initialization block. */
inline fun datePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker = DatePicker(date).apply(init)

/** Add a [DatePicker] to this manager. */
fun NodeManager.datePicker(
    date: LocalDate? = null
): DatePicker = addNode(ktfx.layouts.datePicker(date) { })

/** Add a [DatePicker] with initialization block to this manager. */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker = addNode(ktfx.layouts.datePicker(date, init))
