@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [FlowPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxFlowPane(orientation: Orientation, hgap: Double, vgap: Double) : FlowPane(orientation, hgap, vgap),
    NodeManager, MarginConstraintable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Constraints.clear(): Unit =
        clearConstraints(node)

    final override var Constraints.margin: Insets?
        get() = getMargin(node)
        set(value) = setMargin(node, value)
}

/** Create a [FlowPane] with initialization block. */
inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: KtfxFlowPane.() -> Unit
): FlowPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxFlowPane(orientation, hgap, vgap).apply(init)
}

/** Add a [FlowPane] to this manager. */
fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap
): FlowPane = addNode(KtfxFlowPane(orientation, hgap, vgap))

/** Add a [FlowPane] with initialization block to this manager. */
inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    init: KtfxFlowPane.() -> Unit
): FlowPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxFlowPane(orientation, hgap, vgap), init)
}
