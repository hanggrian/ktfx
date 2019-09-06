@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

/**
 * Invoking layout DSL will only set content to center.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class _BorderPane : BorderPane(), AlignConstraints, MarginConstraints, NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { center = it }

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [BorderPane] with initialization block. */
inline fun borderPane(
    init: (@LayoutDslMarker _BorderPane).() -> Unit
): BorderPane = _BorderPane().apply(init)

/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane =
    addNode(ktfx.layouts.borderPane { })

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: (@LayoutDslMarker _BorderPane).() -> Unit
): BorderPane = addNode(ktfx.layouts.borderPane(init))
