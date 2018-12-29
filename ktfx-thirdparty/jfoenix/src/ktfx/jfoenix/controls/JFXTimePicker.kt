@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTimePicker
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import java.time.LocalTime

/** Creates a [JFXTimePicker]. */
fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: ((@LayoutMarker JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = JFXTimePicker(localTime).also { init?.invoke(it) }

/** Creates a [JFXTimePicker] and add it to this manager. */
inline fun NodeInvokable.jfxTimePicker(
    localTime: LocalTime? = null,
    noinline init: ((@LayoutMarker JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = ktfx.jfoenix.jfxTimePicker(localTime, init)()