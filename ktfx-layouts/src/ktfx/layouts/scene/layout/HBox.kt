@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.layouts.internal.HGrowedPane
import ktfx.layouts.internal.MarginedPane

open class _HBox : HBox(), LayoutManager<Node>, HGrowedPane, MarginedPane {

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.hpriority: Priority get() = getHgrow(this) ?: Priority.NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun hbox(): HBox = hbox { }
inline fun hbox(
    init: (@LayoutDsl _HBox).() -> Unit
): HBox = _HBox().apply(init)

inline fun LayoutManager<Node>.hbox(): HBox = hbox { }
inline fun LayoutManager<Node>.hbox(
    init: (@LayoutDsl _HBox).() -> Unit
): HBox = ktfx.layouts.hbox(init).add()