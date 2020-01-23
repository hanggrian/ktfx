@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

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

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    fun Node.clearConstraints(): Unit = clearConstraints(this)

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
    var Node.horizontalAnchor: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) = setAnchor(topAnchor, value, bottomAnchor, value)

    /** Sets top and bottom anchor of this children. */
    var Node.verticalAnchor: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) = setAnchor(value, rightAnchor, value, leftAnchor)

    /** Sets anchor to all sides of this children. */
    var Node.anchor: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        inline set(value) = setAnchor(value, value, value, value)

    /** Set children anchor on each side in this layout. */
    fun Node.setAnchor(top: Double?, right: Double?, bottom: Double?, left: Double?) {
        topAnchor = top; rightAnchor = right; bottomAnchor = bottom; leftAnchor = left
    }

    /** Configure top anchor fluidly using infix operator. */
    infix fun <C : Node> C.topAnchor(anchor: Double): C = apply { topAnchor = anchor }

    /** Configure right anchor fluidly using infix operator. */
    infix fun <C : Node> C.rightAnchor(anchor: Double): C = apply { rightAnchor = anchor }

    /** Configure bottom anchor fluidly using infix operator. */
    infix fun <C : Node> C.bottomAnchor(anchor: Double): C = apply { bottomAnchor = anchor }

    /** Configure left anchor fluidly using infix operator. */
    infix fun <C : Node> C.leftAnchor(anchor: Double): C = apply { leftAnchor = anchor }

    /** Configure horizontal anchor fluidly using infix operator. */
    infix fun <C : Node> C.horizontalAnchor(anchor: Double): C = apply { horizontalAnchor = anchor }

    /** Configure vertical anchor fluidly using infix operator. */
    infix fun <C : Node> C.verticalAnchor(anchor: Double): C = apply { verticalAnchor = anchor }

    /** Configure all anchor fluidly using infix operator. */
    infix fun <C : Node> C.anchor(anchor: Double): C = apply { this.anchor = anchor }
}

/** Create an [AnchorPane] with initialization block. */
inline fun anchorPane(
    configuration: (@LayoutsDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxAnchorPane().apply(configuration)
}

/** Add an [AnchorPane] to this manager. */
fun NodeManager.anchorPane(): AnchorPane = addChild(KtfxAnchorPane())

/** Add an [AnchorPane] with initialization block to this manager. */
inline fun NodeManager.anchorPane(
    configuration: (@LayoutsDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxAnchorPane(), configuration)
}
