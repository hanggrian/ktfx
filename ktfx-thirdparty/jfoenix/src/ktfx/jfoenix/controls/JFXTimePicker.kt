@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTimePicker] with initialization block. */
inline fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker = JFXTimePicker(localTime).apply(init)

/** Add a [JFXTimePicker] to this manager. */
fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null
): JFXTimePicker = addNode(ktfx.jfoenix.jfxTimePicker(localTime) { })

/** Add a [JFXTimePicker] with initialization block to this manager. */
inline fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null,
    init: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker = addNode(ktfx.jfoenix.jfxTimePicker(localTime, init))
