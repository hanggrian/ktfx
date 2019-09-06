@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXToggleButton] with initialization block. */
inline fun jfxToggleButton(
    init: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton = JFXToggleButton().apply(init)

/** Add a [JFXToggleButton] to this manager. */
fun NodeManager.jfxToggleButton(): JFXToggleButton =
    addNode(ktfx.jfoenix.jfxToggleButton { })

/** Add a [JFXToggleButton] with initialization block to this manager. */
inline fun NodeManager.jfxToggleButton(
    init: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton = addNode(ktfx.jfoenix.jfxToggleButton(init))
