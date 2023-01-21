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

    /** Top anchor of this children. */
    inline var Node.topAnchor: Double?
        @JvmName("getTopAnchor2")
        get() = getTopAnchor(this)

        @JvmName("setTopAnchor2")
        set(value) = setTopAnchor(this, value)

    /** Right anchor of this children. */
    inline var Node.rightAnchor: Double?
        @JvmName("getRightAnchor2")
        get() = getRightAnchor(this)

        @JvmName("setRightAnchor2")
        set(value) = setRightAnchor(this, value)

    /** Bottom anchor of this children. */
    inline var Node.bottomAnchor: Double?
        @JvmName("getBottomAnchor2")
        get() = getBottomAnchor(this)

        @JvmName("setBottomAnchor2")
        set(value) = setBottomAnchor(this, value)

    /** Left anchor of this children. */
    inline var Node.leftAnchor: Double?
        @JvmName("getLeftAnchor2")
        get() = getLeftAnchor(this)

        @JvmName("setLeftAnchor2")
        set(value) = setLeftAnchor(this, value)

    /** Set children anchor on all side in this layout. */
    fun <C : Node> C.anchor(all: Int): C = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(horizontal: Int = Int.MAX_VALUE, vertical: Int = Int.MAX_VALUE): C =
        anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(
        top: Int = Int.MAX_VALUE,
        right: Int = Int.MAX_VALUE,
        bottom: Int = Int.MAX_VALUE,
        left: Int = Int.MAX_VALUE
    ): C = anchor(
        if (top != Int.MAX_VALUE) top.toDouble() else Double.NaN,
        if (right != Int.MAX_VALUE) right.toDouble() else Double.NaN,
        if (bottom != Int.MAX_VALUE) bottom.toDouble() else Double.NaN,
        if (left != Int.MAX_VALUE) left.toDouble() else Double.NaN
    )

    /** Set children anchor on all side in this layout. */
    fun <C : Node> C.anchor(all: Long): C = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(horizontal: Long = Long.MAX_VALUE, vertical: Long = Long.MAX_VALUE): C =
        anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(
        top: Long = Long.MAX_VALUE,
        right: Long = Long.MAX_VALUE,
        bottom: Long = Long.MAX_VALUE,
        left: Long = Long.MAX_VALUE
    ): C = anchor(
        if (top != Long.MAX_VALUE) top.toDouble() else Double.NaN,
        if (right != Long.MAX_VALUE) right.toDouble() else Double.NaN,
        if (bottom != Long.MAX_VALUE) bottom.toDouble() else Double.NaN,
        if (left != Long.MAX_VALUE) left.toDouble() else Double.NaN
    )

    /** Set children anchor on all side in this layout. */
    fun <C : Node> C.anchor(all: Double): C = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    fun <C : Node> C.anchor(horizontal: Double = Double.NaN, vertical: Double = Double.NaN): C =
        anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    @Suppress("ConvertNaNEquality")
    fun <C : Node> C.anchor(
        top: Double = Double.NaN,
        right: Double = Double.NaN,
        bottom: Double = Double.NaN,
        left: Double = Double.NaN
    ): C {
        if (topAnchor != Double.NaN) topAnchor = top
        if (rightAnchor != Double.NaN) rightAnchor = right
        if (bottomAnchor != Double.NaN) bottomAnchor = bottom
        if (leftAnchor != Double.NaN) leftAnchor = left
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
