@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.jfoenix

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class KtfxJFXClippedPane : JFXClippedPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }
}

/** Create a [JFXClippedPane] with initialization block. */
inline fun jfxClippedPane(
    init: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane = KtfxJFXClippedPane().apply(init)

/** Add a [JFXClippedPane] to this manager. */
fun NodeManager.jfxClippedPane(): JFXClippedPane =
    addNode(ktfx.jfoenix.jfxClippedPane { })

/** Add a [JFXClippedPane] with initialization block to this manager. */
inline fun NodeManager.jfxClippedPane(
    init: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane = addNode(ktfx.jfoenix.jfxClippedPane(init))
