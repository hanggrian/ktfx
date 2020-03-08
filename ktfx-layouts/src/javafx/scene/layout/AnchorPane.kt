@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/**
 * [AnchorPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxAnchorPane : AnchorPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Top anchor of this children. */
    inline var Node.topAnchor: Double?
        @JvmName("getTopAnchor2") get() = getTopAnchor(this)
        @JvmName("setTopAnchor2") set(value) = setTopAnchor(this, value)

    /** Right anchor of this children. */
    inline var Node.rightAnchor: Double?
        @JvmName("getRightAnchor2") get() = getRightAnchor(this)
        @JvmName("setRightAnchor2") set(value) = setRightAnchor(this, value)

    /** Bottom anchor of this children. */
    inline var Node.bottomAnchor: Double?
        @JvmName("getBottomAnchor2") get() = getBottomAnchor(this)
        @JvmName("setBottomAnchor2") set(value) = setBottomAnchor(this, value)

    /** Left anchor of this children. */
    inline var Node.leftAnchor: Double?
        @JvmName("getLeftAnchor2") get() = getLeftAnchor(this)
        @JvmName("setLeftAnchor2") set(value) = setLeftAnchor(this, value)

    /** Sets left and right anchor of this children. */
    inline var Node.horizontalAnchor: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) = setAnchor(topAnchor, value, bottomAnchor, value)

    /** Sets top and bottom anchor of this children. */
    inline var Node.verticalAnchor: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) = setAnchor(value, rightAnchor, value, leftAnchor)

    /** Sets anchor to all sides of this children. */
    inline var Node.anchors: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) = setAnchor(value, value, value, value)

    /** Set children anchor on each side in this layout. */
    fun Node.setAnchor(top: Double?, right: Double?, bottom: Double?, left: Double?) {
        topAnchor = top
        rightAnchor = right
        bottomAnchor = bottom
        leftAnchor = left
    }

    /** Configure top anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.topAnchor(anchor: Double): C {
        topAnchor = anchor
        return this
    }

    /** Configure right anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.rightAnchor(anchor: Double): C {
        rightAnchor = anchor
        return this
    }

    /** Configure bottom anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.bottomAnchor(anchor: Double): C {
        bottomAnchor = anchor
        return this
    }

    /** Configure left anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.leftAnchor(anchor: Double): C {
        leftAnchor = anchor
        return this
    }

    /** Configure horizontal anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.horizontalAnchor(anchor: Double): C {
        horizontalAnchor = anchor
        return this
    }

    /** Configure vertical anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.verticalAnchor(anchor: Double): C {
        verticalAnchor = anchor
        return this
    }

    /** Configure all anchor fluidly using infix operator. */
    inline infix fun <C : Node> C.anchors(anchor: Double): C {
        anchors = anchor
        return this
    }
}

/** Create an [AnchorPane] with configuration block. */
inline fun anchorPane(
    configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxAnchorPane().apply(configuration)
}

/** Add an [AnchorPane] to this manager. */
fun NodeManager.anchorPane(): AnchorPane = addChild(KtfxAnchorPane())

/** Add an [AnchorPane] with configuration block to this manager. */
inline fun NodeManager.anchorPane(
    configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxAnchorPane(), configuration)
}
