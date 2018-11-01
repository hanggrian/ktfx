@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [JFXToggleNode]. */
fun jfxToggleNode(
    graphic: Node? = null,
    init: ((@LayoutDsl JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = JFXToggleNode(graphic).also { init?.invoke(it) }

/** Creates a [JFXToggleNode] and add it to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    noinline init: ((@LayoutDsl JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = ktfx.jfoenix.jfxToggleNode(graphic, init)()