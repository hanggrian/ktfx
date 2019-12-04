@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
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
 * [BorderPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its center. There is currently no way to configure other areas (top, left, right, bottom) with dsl.
 * Instead, create an instance and set it manually (e.g: `left = ktfx.layouts.label()`).
 */
open class KtfxBorderPane : BorderPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { center = it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2") get() = getAlignment(this)
        @JvmName("setAlignment2") set(value) = setAlignment(this, value)

    /** Configure alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.align(pos: Pos): C = apply { alignment = pos }

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

/** Create a [BorderPane] with initialization block. */
inline fun borderPane(
    init: (@LayoutsDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxBorderPane().apply(init)
}

/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane = addChild(KtfxBorderPane())

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: (@LayoutsDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxBorderPane(), init)
}
