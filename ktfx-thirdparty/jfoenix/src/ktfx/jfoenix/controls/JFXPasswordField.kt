@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXPasswordField]. */
fun jfxPasswordField(
    init: ((@LayoutMarker JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = JFXPasswordField().also { init?.invoke(it) }

/** Creates a [JFXPasswordField] and add it to this manager. */
inline fun NodeInvokable.jfxPasswordField(
    noinline init: ((@LayoutMarker JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = ktfx.jfoenix.jfxPasswordField(init)()