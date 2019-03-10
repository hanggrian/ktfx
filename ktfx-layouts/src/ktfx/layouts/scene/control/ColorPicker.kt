@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE

/** Creates a [ColorPicker]. */
fun colorPicker(
    color: Color = WHITE,
    init: ((@LayoutMarker ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).also { init?.invoke(it) }

/** Creates a [ColorPicker] and add it to this manager. */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    noinline init: ((@LayoutMarker ColorPicker).() -> Unit)? = null
): ColorPicker = ktfx.layouts.colorPicker(color, init).add()