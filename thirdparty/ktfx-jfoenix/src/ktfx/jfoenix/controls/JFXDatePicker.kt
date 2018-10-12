@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXDatePicker
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import java.time.LocalDate

/** Creates a [JFXDatePicker]. */
fun jfxDatePicker(
    date: LocalDate? = null,
    init: ((@LayoutDsl JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = JFXDatePicker(date).also { init?.invoke(it) }

/** Creates a [JFXDatePicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxDatePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDsl JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = ktfx.jfoenix.jfxDatePicker(date, init)()