@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

/**
 * [VBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxVBox(spacing: Double) :
    VBox(spacing),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Children vertical grow priority in this layout. */
    public inline var Node.vgrow: Priority?
        @JvmName("getVgrow2")
        get() = getVgrow(this)

        @JvmName("setVgrow2")
        set(value) = setVgrow(this, value)

    /** Configure [vgrow] fluidly. */
    public fun <T : Node> T.vgrow(always: Boolean = true): T {
        vgrow = if (always) Priority.ALWAYS else Priority.NEVER
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
