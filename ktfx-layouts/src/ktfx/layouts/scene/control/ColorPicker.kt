@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE

inline fun colorPicker(
    color: Color = WHITE
): ColorPicker = colorPicker(color) { }

inline fun colorPicker(
    color: Color = WHITE,
    init: (@LayoutDsl ColorPicker).() -> Unit
): ColorPicker = ColorPicker(color).apply(init)

inline fun LayoutManager<Node>.colorPicker(
    color: Color = WHITE
): ColorPicker = colorPicker(color) { }

inline fun LayoutManager<Node>.colorPicker(
    color: Color = WHITE,
    init: (@LayoutDsl ColorPicker).() -> Unit
): ColorPicker = ktfx.layouts.colorPicker(color, init).add()