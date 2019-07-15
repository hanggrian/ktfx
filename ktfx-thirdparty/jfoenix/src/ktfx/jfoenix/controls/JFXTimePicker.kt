@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXTimePicker]. */
fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: ((@LayoutDslMarker JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = JFXTimePicker(localTime).also { init?.invoke(it) }

/** Creates a [JFXTimePicker] and add it to this manager. */
inline fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null,
    noinline init: ((@LayoutDslMarker JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = ktfx.jfoenix.jfxTimePicker(localTime, init).add()
