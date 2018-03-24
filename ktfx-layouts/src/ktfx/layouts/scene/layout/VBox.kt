@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

open class _VBox : VBox(), LayoutManager<Node>, VGrowedPane, MarginedPane {

    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.vpriority: Priority get() = getVgrow(this) ?: Priority.NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun vbox(
    noinline init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = _VBox().also { init?.invoke(it) }

inline fun LayoutManager<Node>.vbox(
    noinline init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = ktfx.layouts.vbox(init).add()