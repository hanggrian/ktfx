@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import kotlin.contracts.ExperimentalContracts

/**
 * [StackPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxStackPane : StackPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2") get() = getAlignment(this)
        @JvmName("setAlignment2") set(value) = setAlignment(this, value)

    /** Configure alignment fluidly. */
    fun <C : Node> C.align(pos: Pos): C {
        alignment = pos
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Set children margin in this layout. */
    fun <C : Node> C.margin(insets: Insets): C {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
