@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXColorPicker] to this manager. */
fun NodeManager.jfxColorPicker(
    color: Color? = null
): JFXColorPicker = JFXColorPicker(color).add()

/** Add a [JFXColorPicker] with initialization block to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    init: (@LayoutDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker = jfxColorPicker(color).apply(init)
