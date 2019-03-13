@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutDslMarker

/** Creates a [JFXPasswordField]. */
fun jfxPasswordField(
    init: ((@LayoutDslMarker JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = JFXPasswordField().also { init?.invoke(it) }

/** Creates a [JFXPasswordField] and add it to this manager. */
inline fun NodeManager.jfxPasswordField(
    noinline init: ((@LayoutDslMarker JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = ktfx.jfoenix.jfxPasswordField(init).add()