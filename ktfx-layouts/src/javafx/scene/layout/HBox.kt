@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [HBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxHBox(spacing: Double) : HBox(spacing), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2") get() = getHgrow(this)
        @JvmName("setHgrow2") set(value) = setHgrow(this, value)

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <C : Node> C.hgrow(priority: Priority): C = apply { hgrow = priority }

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <C : Node> C.hgrow(always: Boolean): C = hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

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

/** Create an [HBox] with initialization block. */
inline fun hbox(
    spacing: Double = 0.0,
    init: (@LayoutsDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxHBox(spacing).apply(init)
}

/** Add an [HBox] to this manager. */
fun NodeManager.hbox(
    spacing: Double = 0.0
): HBox = addChild(KtfxHBox(spacing))

/** Add an [HBox] with initialization block to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    init: (@LayoutsDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxHBox(spacing), init)
}
