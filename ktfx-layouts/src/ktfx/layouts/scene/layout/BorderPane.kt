@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

/**
 * Invoking layout DSL will only set content to center.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class KtfxBorderPane : BorderPane(), AlignConstraints, MarginConstraints, NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { center = it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    final override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [BorderPane] with initialization block. */
inline fun borderPane(
    init: (@LayoutDslMarker KtfxBorderPane).() -> Unit
): BorderPane = KtfxBorderPane().apply(init)

/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane =
    addNode(ktfx.layouts.borderPane { })

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: (@LayoutDslMarker KtfxBorderPane).() -> Unit
): BorderPane = addNode(ktfx.layouts.borderPane(init))
