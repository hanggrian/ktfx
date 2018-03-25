@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color

inline fun colorPicker(
    color: Color = Color.WHITE,
    noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).also { init?.invoke(it) }

inline fun LayoutManager<Node>.colorPicker(
    color: Color = Color.WHITE,
    noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ktfx.layouts.colorPicker(color, init).add()