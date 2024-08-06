@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import kotlin.contracts.ExperimentalContracts

/**
 * [BorderPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its center. There is currently no way to configure other areas (top, left, right, bottom) with dsl.
 * Instead, create an instance and set it manually (e.g: `left = ktfx.layouts.label()`).
 */
open class KtfxBorderPane :
    BorderPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { center = it }

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2")
        get() = getAlignment(this)

        @JvmName("setAlignment2")
        set(value) = setAlignment(this, value)

    /** Configure [alignment] fluidly. */
    fun <T : Node> T.align(pos: Pos): T {
        alignment = pos
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2")
        get() = getMargin(this)

        @JvmName("setMargin2")
        set(value) = setMargin(this, value)

    /** Configure [margin] fluidly. */
    fun <T : Node> T.margin(insets: Insets): T {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
