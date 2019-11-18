@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [VBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager, VGrowConstraintable, MarginConstraintable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Constraints.clear(): Unit =
        clearConstraints(node)

    final override var Constraints.vgrow: Priority?
        get() = getVgrow(node)
        set(value) = setVgrow(node, value)

    final override var Constraints.margin: Insets?
        get() = getMargin(node)
        set(value) = setMargin(node, value)
}

/** Create a [VBox] with initialization block. */
inline fun vbox(
    spacing: Double = 0.0,
    init: KtfxVBox.() -> Unit
): VBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxVBox(spacing).apply(init)
}

/** Add a [VBox] to this manager. */
fun NodeManager.vbox(
    spacing: Double = 0.0
): VBox = addNode(KtfxVBox(spacing))

/** Add a [VBox] with initialization block to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    init: KtfxVBox.() -> Unit
): VBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxVBox(spacing), init)
}
