@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
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
    NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Configure children margin, taking account of current margin. */
    inline fun Node.updateMargin(
        top: Double? = margin?.top,
        right: Double? = margin?.right,
        bottom: Double? = margin?.bottom,
        left: Double? = margin?.left
    ) {
        margin = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margin(margin: Insets): C = apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginAll(margin: Double): C = apply { this.margin = Insets(margin) }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginTop(margin: Double): C = apply { updateMargin(top = margin) }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginRight(margin: Double): C = apply { updateMargin(right = margin) }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginBottom(margin: Double): C = apply { updateMargin(bottom = margin) }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginLeft(margin: Double): C = apply { updateMargin(left = margin) }
}

/** Create a [FlowPane] with initialization block. */
inline fun flowPane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    configuration: (@LayoutsDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxFlowPane(orientation, hgap, vgap).apply(configuration)
}

/** Add a [FlowPane] to this manager. */
fun NodeManager.flowPane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap
): FlowPane = addChild(KtfxFlowPane(orientation, hgap, vgap))

/** Add a [FlowPane] with initialization block to this manager. */
inline fun NodeManager.flowPane(
    orientation: Orientation = Orientation.HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = hgap,
    configuration: (@LayoutsDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxFlowPane(orientation, hgap, vgap), configuration)
}
