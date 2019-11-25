@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
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
open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <T : Node> T.vgrow(priority: Priority): T = apply { vgrow = priority }

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <T : Node> T.vgrow(always: Boolean): T = vgrow(if (always) Priority.ALWAYS else Priority.NEVER)

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
    inline infix fun <T : Node> T.margin(margin: Insets): T = apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginAll(margin: Double): T = apply { this.margin = Insets(margin) }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginTop(margin: Double): T = apply { updateMargin(top = margin) }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginRight(margin: Double): T = apply { updateMargin(right = margin) }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginBottom(margin: Double): T = apply { updateMargin(bottom = margin) }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginLeft(margin: Double): T = apply { updateMargin(left = margin) }
}

/** Create a [VBox] with initialization block. */
inline fun vbox(
    spacing: Double = 0.0,
    init: (@KtfxLayoutsDslMarker KtfxVBox).() -> Unit
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
    init: (@KtfxLayoutsDslMarker KtfxVBox).() -> Unit
): VBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxVBox(spacing), init)
}
