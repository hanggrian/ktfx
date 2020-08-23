@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import kotlin.contracts.ExperimentalContracts

/**
 * [FlowPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxFlowPane(orientation: Orientation, hgap: Double, vgap: Double) :
    FlowPane(orientation, hgap, vgap),
    NodeManager {

    constructor(orientation: Orientation, gap: Double) : this(orientation, gap, gap)

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Set children margin on all side in this layout. */
    fun <C : Node> C.margin(all: Number): C {
        margin = Insets(all.toDouble())
        return this
    }

    /** Set children margin on each side in this layout. */
    fun <C : Node> C.margin(horizontal: Number? = null, vertical: Number? = null): C = margin(
        vertical ?: margin?.top,
        horizontal ?: margin?.right,
        vertical ?: margin?.bottom,
        horizontal ?: margin?.left
    )

    /** Set children margin on each side in this layout. */
    fun <C : Node> C.margin(
        top: Number? = margin?.top,
        right: Number? = margin?.right,
        bottom: Number? = margin?.bottom,
        left: Number? = margin?.left
    ): C {
        margin =
            Insets(top?.toDouble() ?: 0.0, right?.toDouble() ?: 0.0, bottom?.toDouble() ?: 0.0, left?.toDouble() ?: 0.0)
        return this
    }
}
