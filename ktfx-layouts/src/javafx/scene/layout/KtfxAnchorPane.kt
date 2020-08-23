@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotlin.contracts.ExperimentalContracts

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

    /** Set children anchor on all side in this layout. */
    fun <C : Node> C.anchor(all: Number): C = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(horizontal: Number? = null, vertical: Number? = null): C = anchor(
        vertical ?: topAnchor,
        horizontal ?: rightAnchor,
        vertical ?: bottomAnchor,
        horizontal ?: leftAnchor
    )

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(
        top: Number? = topAnchor,
        right: Number? = rightAnchor,
        bottom: Number? = bottomAnchor,
        left: Number? = leftAnchor
    ): C {
        if (top != topAnchor) topAnchor = top?.toDouble()
        if (right != rightAnchor) rightAnchor = right?.toDouble()
        if (bottom != bottomAnchor) bottomAnchor = bottom?.toDouble()
        if (left != leftAnchor) leftAnchor = left?.toDouble()
        return this
    }
}
