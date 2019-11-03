@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTimePicker] with initialization block. */
inline fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker = JFXTimePicker(localTime).apply(init)

/** Add a [JFXTimePicker] to this manager. */
fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null
): JFXTimePicker = addNode(JFXTimePicker(localTime))

/** Add a [JFXTimePicker] with initialization block to this manager. */
inline fun NodeManager.jfxTimePicker(
    localTime: LocalTime? = null,
    init: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker = addNode(JFXTimePicker(localTime), init)
