@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority

/**
 * [HBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxHBox(spacing: Double) :
    HBox(spacing),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Children horizontal grow priority in this layout. */
    public inline var Node.hgrow: Priority?
        @JvmName("getHgrow2")
        get() = getHgrow(this)

        @JvmName("setHgrow2")
        set(value) = setHgrow(this, value)

    /** Configure [hgrow] fluidly. */
    public fun <T : Node> T.hgrow(always: Boolean = true): T {
        hgrow = if (always) Priority.ALWAYS else Priority.NEVER
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
