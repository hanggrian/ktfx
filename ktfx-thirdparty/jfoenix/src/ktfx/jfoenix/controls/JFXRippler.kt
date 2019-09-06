@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

// TODO: should include mask & pos in constructor?
open class _JFXRippler : JFXRippler(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { control = it }
}

/** Create a [JFXRippler] with initialization block. */
inline fun jfxRippler(
    init: (@LayoutDslMarker _JFXRippler).() -> Unit
): JFXRippler = _JFXRippler().apply(init)

/** Add a [JFXRippler] to this manager. */
fun NodeManager.jfxRippler(): JFXRippler =
    addNode(ktfx.jfoenix.jfxRippler { })

/** Add a [JFXRippler] with initialization block to this manager. */
inline fun NodeManager.jfxRippler(
    init: (@LayoutDslMarker _JFXRippler).() -> Unit
): JFXRippler = addNode(ktfx.jfoenix.jfxRippler(init))
