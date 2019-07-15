@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXToggleButton]. */
fun jfxToggleButton(
    init: ((@LayoutDslMarker JFXToggleButton).() -> Unit)? = null
): JFXToggleButton = JFXToggleButton().also { init?.invoke(it) }

/** Creates a [JFXToggleButton] and add it to this manager. */
inline fun NodeManager.jfxToggleButton(
    noinline init: ((@LayoutDslMarker JFXToggleButton).() -> Unit)? = null
): JFXToggleButton = ktfx.jfoenix.jfxToggleButton(init).add()
