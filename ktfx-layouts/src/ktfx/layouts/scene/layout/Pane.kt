@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane : Pane(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create a [Pane] with initialization block. */
inline fun pane(
    init: (@LayoutDslMarker _Pane).() -> Unit
): Pane = _Pane().apply(init)

/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane =
    addNode(ktfx.layouts.pane { })

/** Add a [Pane] with initialization block to this manager. */
inline fun NodeManager.pane(
    init: (@LayoutDslMarker _Pane).() -> Unit
): Pane = addNode(ktfx.layouts.pane(init))
