@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTimePicker] to this manager. */
fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null
): JFXTimePicker = JFXTimePicker(localTime).add()

/** Add a [JFXTimePicker] with initialization block to this manager. */
inline fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null,
    init: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker = jfxTimePicker(localTime).apply(init)
