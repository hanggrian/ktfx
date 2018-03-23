@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane

open class _TilePane : TilePane(), ChildLayoutManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun tilePane(
    noinline init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = _TilePane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.tilePane(
    noinline init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = ktfx.layouts.tilePane(init).add()