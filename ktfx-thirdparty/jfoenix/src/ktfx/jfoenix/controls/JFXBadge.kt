@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXBadge : JFXBadge(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { control = it }
}

/** Create a [JFXBadge] with initialization block. */
inline fun jfxBadge(
    init: (@LayoutDslMarker _JFXBadge).() -> Unit
): JFXBadge = _JFXBadge().apply(init)

/** Add a [JFXBadge] to this manager. */
fun NodeManager.jfxBadge(): JFXBadge =
    addNode(ktfx.jfoenix.jfxBadge { })

/** Add a [JFXBadge] with initialization block to this manager. */
inline fun NodeManager.jfxBadge(
    init: (@LayoutDslMarker _JFXBadge).() -> Unit
): JFXBadge = addNode(ktfx.jfoenix.jfxBadge(init))
