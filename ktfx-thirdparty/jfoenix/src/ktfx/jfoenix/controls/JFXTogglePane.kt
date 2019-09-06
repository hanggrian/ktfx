@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTogglePane] with initialization block. */
inline fun jfxTogglePane(
    init: (@LayoutDslMarker JFXTogglePane).() -> Unit
): JFXTogglePane = JFXTogglePane().apply(init)

/** Add a [JFXTogglePane] to this manager. */
fun NodeManager.jfxTogglePane(): JFXTogglePane =
    addNode(ktfx.jfoenix.jfxTogglePane { })

/** Add a [JFXTogglePane] with initialization block to this manager. */
inline fun NodeManager.jfxTogglePane(
    init: (@LayoutDslMarker JFXTogglePane).() -> Unit
): JFXTogglePane = addNode(ktfx.jfoenix.jfxTogglePane(init))
