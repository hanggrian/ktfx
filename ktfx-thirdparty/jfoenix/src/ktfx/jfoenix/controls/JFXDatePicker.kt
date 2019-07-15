@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDatePicker
import java.time.LocalDate
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXDatePicker]. */
fun jfxDatePicker(
    date: LocalDate? = null,
    init: ((@LayoutDslMarker JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = JFXDatePicker(date).also { init?.invoke(it) }

/** Creates a [JFXDatePicker] and add it to this manager. */
inline fun NodeManager.jfxDatePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutDslMarker JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = ktfx.jfoenix.jfxDatePicker(date, init).add()
