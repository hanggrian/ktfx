@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node

open class _Group : Group(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create a [Group] with initialization block. */
inline fun group(
    init: (@LayoutDslMarker _Group).() -> Unit
): Group = _Group().apply(init)

/** Add a [Group] to this manager. */
fun NodeManager.group(): Group =
    addNode(ktfx.layouts.group { })

/** Add a [Group] with initialization block to this manager. */
inline fun NodeManager.group(
    init: (@LayoutDslMarker _Group).() -> Unit
): Group = addNode(ktfx.layouts.group(init))
