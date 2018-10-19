@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTimePicker
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import java.time.LocalTime

/** Creates a [JFXTimePicker]. */
fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: ((@LayoutDsl JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = JFXTimePicker(localTime).also { init?.invoke(it) }

/** Creates a [JFXTimePicker] and add it to this manager. */
inline fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null,
    noinline init: ((@LayoutDsl JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = ktfx.jfoenix.jfxTimePicker(localTime, init)()