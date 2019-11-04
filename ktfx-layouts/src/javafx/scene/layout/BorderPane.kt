@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Invoking layout DSL will only set content to center.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class KtfxBorderPane : BorderPane(), AlignConstraints, MarginConstraints, SidesNodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { center = it }

    final override fun <T : Node> addTopNode(node: T): T =
        node.also { top = it }

    final override fun <T : Node> addRightNode(node: T): T =
        node.also { right = it }

    final override fun <T : Node> addBottomNode(node: T): T =
        node.also { bottom = it }

    final override fun <T : Node> addLeftNode(node: T): T =
        node.also { left = it }

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
): BorderPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return KtfxBorderPane().apply(init)
}
/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane =
    addNode(KtfxBorderPane())

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: (@LayoutDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(KtfxBorderPane(), init)
}
