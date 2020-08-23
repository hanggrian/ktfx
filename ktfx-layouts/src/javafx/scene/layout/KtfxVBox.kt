@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotlin.contracts.ExperimentalContracts

/**
 * [VBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure vertical grow fluidly. */
    fun <C : Node> C.vgrow(always: Boolean = true): C {
        vgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

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
