@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _BorderPane : BorderPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)
}

inline fun borderPane(): BorderPane = borderPane { }

inline fun borderPane(
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = _BorderPane().apply(init)

inline fun LayoutManager<Node>.borderPane(): BorderPane = borderPane { }

inline fun LayoutManager<Node>.borderPane(
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = ktfx.layouts.borderPane(init).add()