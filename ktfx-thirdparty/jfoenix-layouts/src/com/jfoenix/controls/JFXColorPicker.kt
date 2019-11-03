@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXColorPicker] with initialization block. */
inline fun jfxColorPicker(
    color: Color? = null,
    init: (@LayoutDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker = JFXColorPicker(color).apply(init)

/** Add a [JFXColorPicker] to this manager. */
fun NodeManager.jfxColorPicker(
    color: Color? = null
): JFXColorPicker = addNode(JFXColorPicker(color))

/** Add a [JFXColorPicker] with initialization block to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    init: (@LayoutDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker = addNode(JFXColorPicker(color), init)
