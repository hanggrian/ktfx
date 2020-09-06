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

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure [vgrow] fluidly. */
    fun <C : Node> C.vgrow(always: Boolean = true): C {
        vgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Configure [margin] fluidly. */
    fun <C : Node> C.margin(insets: Insets): C {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
