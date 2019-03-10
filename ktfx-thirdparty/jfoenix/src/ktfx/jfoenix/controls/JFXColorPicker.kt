@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXColorPicker]. */
fun jfxColorPicker(
    color: Color? = null,
    init: ((@LayoutMarker JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = JFXColorPicker(color).also { init?.invoke(it) }

/** Creates a [JFXColorPicker] and add it to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    noinline init: ((@LayoutMarker JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = ktfx.jfoenix.jfxColorPicker(color, init).add()