@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXColorPicker]. */
fun jfxColorPicker(
    color: Color? = null,
    init: ((@LayoutDsl JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = JFXColorPicker(color).also { init?.invoke(it) }

/** Creates a [JFXColorPicker] and add it to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    noinline init: ((@LayoutDsl JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = ktfx.jfoenix.jfxColorPicker(color, init)()