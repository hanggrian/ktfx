@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _TilePane : TilePane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

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