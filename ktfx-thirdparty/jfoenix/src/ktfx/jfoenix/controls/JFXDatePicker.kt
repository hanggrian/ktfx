@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import java.time.LocalDate

/** Creates a [JFXDatePicker]. */
fun jfxDatePicker(
    date: LocalDate? = null,
    init: ((@LayoutMarker JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = JFXDatePicker(date).also { init?.invoke(it) }

/** Creates a [JFXDatePicker] and add it to this manager. */
inline fun NodeInvokable.jfxDatePicker(
    date: LocalDate? = null,
    noinline init: ((@LayoutMarker JFXDatePicker).() -> Unit)? = null
): JFXDatePicker = ktfx.jfoenix.jfxDatePicker(date, init)()