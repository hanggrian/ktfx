@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [StackPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxStackPane : StackPane(), NodeManager, AlignmentConstraintable, MarginConstraintable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Constraints.clear(): Unit =
        clearConstraints(node)

    final override var Constraints.alignment: Pos?
        get() = getAlignment(node)
        set(value) = setAlignment(node, value)

    final override var Constraints.margin: Insets?
        get() = getMargin(node)
        set(value) = setMargin(node, value)
}

/** Create a [StackPane] with initialization block. */
inline fun stackPane(
    init: KtfxStackPane.() -> Unit
): StackPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxStackPane().apply(init)
}

/** Add a [StackPane] to this manager. */
fun NodeManager.stackPane(): StackPane =
    addNode(KtfxStackPane())

/** Add a [StackPane] with initialization block to this manager. */
inline fun NodeManager.stackPane(
    init: KtfxStackPane.() -> Unit
): StackPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxStackPane(), init)
}
