@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE

/** Create a [ColorPicker] with initialization block. */
inline fun colorPicker(
    color: Color = WHITE,
    init: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker = ColorPicker(color).apply(init)

/** Add a [ColorPicker] to this manager. */
fun NodeManager.colorPicker(
    color: Color = WHITE
): ColorPicker = addNode(ColorPicker(color))

/** Add a [ColorPicker] with initialization block to this manager. */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    init: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker = addNode(ColorPicker(color), init)
