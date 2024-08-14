@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane

/**
 * [StackPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxStackPane :
    StackPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Children alignment in this layout. */
    public inline var Node.alignment: Pos?
        @JvmName("getAlignment2")
        get() = getAlignment(this)

        @JvmName("setAlignment2")
        set(value) = setAlignment(this, value)

    /** Configure [alignment] fluidly. */
    public fun <T : Node> T.align(pos: Pos): T {
        alignment = pos
        return this
    }

    /** Children margin in this layout. */
    public inline var Node.margin: Insets?
        @JvmName("getMargin2")
        get() = getMargin(this)

        @JvmName("setMargin2")
        set(value) = setMargin(this, value)

    /** Configure [margin] fluidly. */
    public fun <T : Node> T.margin(insets: Insets): T {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    public inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
