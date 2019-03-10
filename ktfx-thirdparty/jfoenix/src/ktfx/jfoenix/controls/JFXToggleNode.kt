@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXToggleNode]. */
fun jfxToggleNode(
    graphic: Node? = null,
    init: ((@LayoutMarker JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = JFXToggleNode(graphic).also { init?.invoke(it) }

/** Creates a [JFXToggleNode] and add it to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    noinline init: ((@LayoutMarker JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = ktfx.jfoenix.jfxToggleNode(graphic, init).add()