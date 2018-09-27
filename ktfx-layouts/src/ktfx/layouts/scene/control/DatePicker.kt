@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

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