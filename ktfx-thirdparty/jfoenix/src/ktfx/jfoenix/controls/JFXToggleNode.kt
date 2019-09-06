@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXToggleNode] with initialization block. */
inline fun jfxToggleNode(
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode = JFXToggleNode(graphic).apply(init)

/** Add a [JFXToggleNode] to this manager. */
fun NodeManager.jfxToggleNode(
    graphic: Node? = null
): JFXToggleNode = addNode(ktfx.jfoenix.jfxToggleNode(graphic) { })

/** Add a [JFXToggleNode] with initialization block to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode = addNode(ktfx.jfoenix.jfxToggleNode(graphic, init))
