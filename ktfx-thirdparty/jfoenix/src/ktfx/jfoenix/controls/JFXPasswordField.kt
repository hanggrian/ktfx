@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXPasswordField] to this manager. */
fun NodeManager.jfxPasswordField(): JFXPasswordField =
    JFXPasswordField().add()

/** Add a [JFXPasswordField] with initialization to this manager. */
inline fun NodeManager.jfxPasswordField(
    init: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField = jfxPasswordField().apply(init)
