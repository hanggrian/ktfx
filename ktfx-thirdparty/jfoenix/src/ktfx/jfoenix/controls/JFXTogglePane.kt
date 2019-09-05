@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTogglePane] to this manager. */
fun NodeManager.jfxTogglePane(): JFXTogglePane =
    JFXTogglePane().add()

/** Add a [JFXTogglePane] with initialization block to this manager. */
inline fun NodeManager.jfxTogglePane(
    init: (@LayoutDslMarker JFXTogglePane).() -> Unit
): JFXTogglePane = jfxTogglePane().apply(init)
