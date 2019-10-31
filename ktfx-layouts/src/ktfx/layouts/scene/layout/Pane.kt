@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

open class KtfxPane : Pane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }
}

/** Create a [Pane] with initialization block. */
inline fun pane(
    init: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane = KtfxPane().apply(init)

/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane =
    addNode(KtfxPane())

/** Add a [Pane] with initialization block to this manager. */
inline fun NodeManager.pane(
    init: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane = addNode(KtfxPane(), init)
