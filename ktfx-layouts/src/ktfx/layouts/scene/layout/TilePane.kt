@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _TilePane : TilePane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun tilePane(): TilePane = tilePane { }

inline fun tilePane(
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = _TilePane().apply(init)

inline fun LayoutManager<Node>.tilePane(): TilePane = tilePane { }

inline fun LayoutManager<Node>.tilePane(
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = ktfx.layouts.tilePane(init).add()