@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane

/**
 * [AnchorPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxAnchorPane :
    AnchorPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Top anchor of this children. */
    public inline var Node.topAnchor: Double?
        @JvmName("getTopAnchor2")
        get() = getTopAnchor(this)

        @JvmName("setTopAnchor2")
        set(value) = setTopAnchor(this, value)

    /** Right anchor of this children. */
    public inline var Node.rightAnchor: Double?
        @JvmName("getRightAnchor2")
        get() = getRightAnchor(this)

        @JvmName("setRightAnchor2")
        set(value) = setRightAnchor(this, value)

    /** Bottom anchor of this children. */
    public inline var Node.bottomAnchor: Double?
        @JvmName("getBottomAnchor2")
        get() = getBottomAnchor(this)

        @JvmName("setBottomAnchor2")
        set(value) = setBottomAnchor(this, value)

    /** Left anchor of this children. */
    public inline var Node.leftAnchor: Double?
        @JvmName("getLeftAnchor2")
        get() = getLeftAnchor(this)

        @JvmName("setLeftAnchor2")
        set(value) = setLeftAnchor(this, value)

    /** Set children anchor on all side in this layout. */
    public fun <T : Node> T.anchor(all: Int): T = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        horizontal: Int = Int.MIN_VALUE,
        vertical: Int = Int.MIN_VALUE,
    ): T = anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        top: Int = Int.MIN_VALUE,
        right: Int = Int.MIN_VALUE,
        bottom: Int = Int.MIN_VALUE,
        left: Int = Int.MIN_VALUE,
    ): T =
        anchor(
            if (top != Int.MIN_VALUE) top.toDouble() else Double.NaN,
            if (right != Int.MIN_VALUE) right.toDouble() else Double.NaN,
            if (bottom != Int.MIN_VALUE) bottom.toDouble() else Double.NaN,
            if (left != Int.MIN_VALUE) left.toDouble() else Double.NaN,
        )

    /** Set children anchor on all side in this layout. */
    public fun <T : Node> T.anchor(all: Long): T = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        horizontal: Long = Long.MIN_VALUE,
        vertical: Long = Long.MIN_VALUE,
    ): T = anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        top: Long = Long.MIN_VALUE,
        right: Long = Long.MIN_VALUE,
        bottom: Long = Long.MIN_VALUE,
        left: Long = Long.MIN_VALUE,
    ): T =
        anchor(
            if (top != Long.MIN_VALUE) top.toDouble() else Double.NaN,
            if (right != Long.MIN_VALUE) right.toDouble() else Double.NaN,
            if (bottom != Long.MIN_VALUE) bottom.toDouble() else Double.NaN,
            if (left != Long.MIN_VALUE) left.toDouble() else Double.NaN,
        )

    /** Set children anchor on all side in this layout. */
    public fun <T : Node> T.anchor(all: Double): T = anchor(all, all, all, all)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        horizontal: Double = Double.NaN,
        vertical: Double = Double.NaN,
    ): T = anchor(vertical, horizontal, vertical, horizontal)

    /** Set children anchor on each side in this layout. */
    public fun <T : Node> T.anchor(
        top: Double = Double.NaN,
        right: Double = Double.NaN,
        bottom: Double = Double.NaN,
        left: Double = Double.NaN,
    ): T {
        if (!top.isNaN()) topAnchor = top
        if (!right.isNaN()) rightAnchor = right
        if (!bottom.isNaN()) bottomAnchor = bottom
        if (!left.isNaN()) leftAnchor = left
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    public inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
