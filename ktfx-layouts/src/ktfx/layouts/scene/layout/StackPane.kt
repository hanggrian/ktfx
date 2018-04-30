@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _StackPane(
    vararg children: Node
) : StackPane(*children), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun stackPane(
    vararg children: Node
): StackPane = stackPane(*children) { }

inline fun stackPane(
    vararg children: Node,
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = _StackPane(*children).apply(init)

inline fun LayoutManager<Node>.stackPane(
    vararg children: Node
): StackPane = stackPane(*children) { }

inline fun LayoutManager<Node>.stackPane(
    vararg children: Node,
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = ktfx.layouts.stackPane(*children, init = init).add()