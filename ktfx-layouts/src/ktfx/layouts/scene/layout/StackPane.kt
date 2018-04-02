@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _StackPane : StackPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun stackPane(): StackPane = stackPane { }

inline fun stackPane(
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = _StackPane().apply(init)

inline fun LayoutManager<Node>.stackPane(): StackPane = stackPane { }

inline fun LayoutManager<Node>.stackPane(
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = ktfx.layouts.stackPane(init).add()