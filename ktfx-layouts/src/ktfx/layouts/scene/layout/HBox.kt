@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.layouts.internal.HGrowedPane
import ktfx.layouts.internal.MarginedPane

open class _HBox : HBox(), LayoutManager<Node>, HGrowedPane, MarginedPane {

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override fun Node.clear() = clearConstraints(this)

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