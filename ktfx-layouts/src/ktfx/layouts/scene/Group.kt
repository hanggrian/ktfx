@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Group
import javafx.scene.Node

open class KtfxGroup : Group(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create a [Group] with initialization block. */
inline fun group(
    init: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group = KtfxGroup().apply(init)

/** Add a [Group] to this manager. */
fun NodeManager.group(): Group =
    addNode(ktfx.layouts.group { })

/** Add a [Group] with initialization block to this manager. */
inline fun NodeManager.group(
    init: (@LayoutDslMarker KtfxGroup).() -> Unit
): Group = addNode(ktfx.layouts.group(init))
