@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotlin.contracts.ExperimentalContracts

/**
 * [HBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxHBox(spacing: Double) : HBox(spacing), NodeManager {
    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2")
        get() = getHgrow(this)

        @JvmName("setHgrow2")
        set(value) = setHgrow(this, value)

    /** Configure [hgrow] fluidly. */
    fun <C : Node> C.hgrow(always: Boolean = true): C {
        hgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2")
        get() = getMargin(this)

        @JvmName("setMargin2")
        set(value) = setMargin(this, value)

    /** Configure [margin] fluidly. */
    fun <C : Node> C.margin(insets: Insets): C {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
