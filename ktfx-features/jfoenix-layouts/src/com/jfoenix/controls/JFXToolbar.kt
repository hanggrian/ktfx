@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXToolbar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXToolbar : JFXToolbar() {

    fun leftItems(init: (@LayoutsDslMarker HBoxConstraints).() -> Unit): Unit =
        HBoxConstraints(leftItems).init()

    fun rightItems(init: (@LayoutsDslMarker HBoxConstraints).() -> Unit): Unit =
        HBoxConstraints(rightItems).init()

    @Suppress("NOTHING_TO_INLINE")
    class HBoxConstraints internal constructor(list: MutableList<Node>) : NodeManager, MutableList<Node> by list {
        final override fun <T : Node> addNode(node: T): T = node.also { this += it }

        /** Clear children constraints. */
        @JvmName("clearConstraints2")
        inline fun Node.clearConstraints(): Unit = HBox.clearConstraints(this)

        /** Children horizontal grow priority in this layout. */
        inline var Node.hgrow: Priority?
            @JvmName("getHgrow2") get() = HBox.getHgrow(this)
            @JvmName("setHgrow2") set(value) = HBox.setHgrow(this, value)

        /** Configure horizontal grow fluidly using infix operator. */
        inline infix fun <T : Node> T.hgrow(priority: Priority): T = apply { hgrow = priority }

        /** Configure horizontal grow fluidly using infix operator. */
        inline infix fun <T : Node> T.hgrow(always: Boolean): T = hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

        /** Children margin in this layout. */
        inline var Node.margin: Insets?
            @JvmName("getMargin2") get() = HBox.getMargin(this)
            @JvmName("setMargin2") set(value) = HBox.setMargin(this, value)

        /** Configure children margin, taking account of current margin. */
        inline fun Node.updateMargin(
            top: Double? = margin?.top,
            right: Double? = margin?.right,
            bottom: Double? = margin?.bottom,
            left: Double? = margin?.left
        ) {
            margin = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
        }

        /** Configure margin fluidly using infix operator. */
        inline infix fun <T : Node> T.margin(margin: Insets): T = apply { this.margin = margin }

        /** Configure all sides margin fluidly using infix operator. */
        inline infix fun <T : Node> T.marginAll(margin: Double): T = apply { this.margin = Insets(margin) }

        /** Configure top margin fluidly using infix operator. */
        inline infix fun <T : Node> T.marginTop(margin: Double): T = apply { updateMargin(top = margin) }

        /** Configure right margin fluidly using infix operator. */
        inline infix fun <T : Node> T.marginRight(margin: Double): T = apply { updateMargin(right = margin) }

        /** Configure bottom margin fluidly using infix operator. */
        inline infix fun <T : Node> T.marginBottom(margin: Double): T = apply { updateMargin(bottom = margin) }

        /** Configure left margin fluidly using infix operator. */
        inline infix fun <T : Node> T.marginLeft(margin: Double): T = apply { updateMargin(left = margin) }
    }
}

/** Create a [JFXToolbar] with initialization block. */
inline fun jfxToolbar(
    init: (@LayoutsDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXToolbar().apply(init)
}

/** Add a [JFXToolbar] to this manager. */
fun NodeManager.jfxToolbar(): JFXToolbar =
    addNode(KtfxJFXToolbar())

/** Add a [JFXToolbar] with initialization block to this manager. */
inline fun NodeManager.jfxToolbar(
    init: (@LayoutsDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXToolbar(), init)
}
