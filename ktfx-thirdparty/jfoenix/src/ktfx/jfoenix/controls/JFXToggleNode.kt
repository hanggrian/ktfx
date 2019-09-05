@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXToggleNode] to this manager. */
fun NodeManager.jfxToggleNode(
    graphic: Node? = null
): JFXToggleNode = JFXToggleNode(graphic).add()

/** Add a [JFXToggleNode] with initialization block to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode = jfxToggleNode(graphic).apply(init)
