@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXToggleButton] to this manager. */
fun NodeManager.jfxToggleButton(): JFXToggleButton =
    JFXToggleButton().add()

/** Add a [JFXToggleButton] with initialization block to this manager. */
inline fun NodeManager.jfxToggleButton(
    init: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton = jfxToggleButton().apply(init)
