@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXColorPicker] with initialization block. */
inline fun jfxColorPicker(
    color: Color? = null,
    init: (@LayoutDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker = JFXColorPicker(color).apply(init)

/** Add a [JFXColorPicker] to this manager. */
fun NodeManager.jfxColorPicker(
    color: Color? = null
): JFXColorPicker = addNode(ktfx.jfoenix.jfxColorPicker(color) { })

/** Add a [JFXColorPicker] with initialization block to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    init: (@LayoutDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker = addNode(ktfx.jfoenix.jfxColorPicker(color, init))
