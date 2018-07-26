@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE

/** Creates a [ColorPicker]. */
fun colorPicker(
    color: Color = WHITE,
    init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).also {
    init?.invoke(it)
}

/** Creates a [ColorPicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.colorPicker(
    color: Color = WHITE,
    noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = javafxx.layouts.colorPicker(color, init)()

/** Create a styled [ColorPicker]. */
fun styledColorPicker(
    styleClass: String,
    color: Color = WHITE,
    init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ColorPicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledColorPicker(
    styleClass: String,
    color: Color = WHITE,
    noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = javafxx.layouts.styledColorPicker(styleClass, color, init)()