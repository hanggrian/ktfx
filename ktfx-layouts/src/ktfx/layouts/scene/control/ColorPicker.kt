@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE

/** Add a [ColorPicker] to this manager. */
fun NodeManager.colorPicker(
    color: Color = WHITE
): ColorPicker = ColorPicker(color).add()

/** Add a [ColorPicker] with initialization block to this manager. */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    init: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker = colorPicker(color).apply(init)
