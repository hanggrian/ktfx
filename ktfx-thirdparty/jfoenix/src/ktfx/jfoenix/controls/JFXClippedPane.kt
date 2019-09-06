@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXClippedPane : JFXClippedPane(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create a [JFXClippedPane] with initialization block. */
inline fun jfxClippedPane(
    init: (@LayoutDslMarker _JFXClippedPane).() -> Unit
): JFXClippedPane = _JFXClippedPane().apply(init)

/** Add a [JFXClippedPane] to this manager. */
fun NodeManager.jfxClippedPane(): JFXClippedPane =
    addNode(ktfx.jfoenix.jfxClippedPane { })

/** Add a [JFXClippedPane] with initialization block to this manager. */
inline fun NodeManager.jfxClippedPane(
    init: (@LayoutDslMarker _JFXClippedPane).() -> Unit
): JFXClippedPane = addNode(ktfx.jfoenix.jfxClippedPane(init))
