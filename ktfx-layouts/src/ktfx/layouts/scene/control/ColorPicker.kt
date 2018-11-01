@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [ColorPicker]. */
fun colorPicker(
    color: Color = WHITE,
    init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).also { init?.invoke(it) }

/** Creates a [ColorPicker] and add it to this manager. */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ktfx.layouts.colorPicker(color, init)()