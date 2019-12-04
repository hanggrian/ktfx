@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals

/**
 * [AnchorPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxAnchorPane : AnchorPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children all anchor in this layout. */
    inline var Node.anchorAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    /** Children left anchor in this layout. */
    inline var Node.anchorLeft: Double?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value)

    /** Children top anchor in this layout. */
    inline var Node.anchorTop: Double?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value)

    /** Children bottom anchor in this layout. */
    inline var Node.anchorBottom: Double?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value)

    /** Children right anchor in this layout. */
    inline var Node.anchorRight: Double?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value)

    /** Configure all anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchorAll(anchor: Double): C = apply { anchorAll = anchor }

    /** Configure top anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchorTop(anchor: Double): C = apply { anchorTop = anchor }

    /** Configure left anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchorLeft(anchor: Double): C = apply { anchorLeft = anchor }

    /** Configure bottom anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchorBottom(anchor: Double): C = apply { anchorBottom = anchor }

    /** Configure right anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchorRight(anchor: Double): C = apply { anchorRight = anchor }
}

/** Create an [AnchorPane] with initialization block. */
inline fun anchorPane(
    init: (@LayoutsDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxAnchorPane().apply(init)
}

/** Add an [AnchorPane] to this manager. */
fun NodeManager.anchorPane(): AnchorPane = addChild(KtfxAnchorPane())

/** Add an [AnchorPane] with initialization block to this manager. */
inline fun NodeManager.anchorPane(
    init: (@LayoutsDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxAnchorPane(), init)
}
