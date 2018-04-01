@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _TilePane : TilePane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override fun Node.clear() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun tilePane(): TilePane = tilePane { }

inline fun tilePane(
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = _TilePane().apply(init)

inline fun LayoutManager<Node>.tilePane(): TilePane = tilePane { }

inline fun LayoutManager<Node>.tilePane(
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = ktfx.layouts.tilePane(init).add()