package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane

@Suppress("ClassName")
open class _TilePane : TilePane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = ktfx.layouts.tilePane(init).add()
inline fun ItemManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = ktfx.layouts.tilePane(init).add()
inline fun ButtonManager.tilePane(init: (@LayoutDsl _TilePane).() -> Unit): TilePane = ktfx.layouts.tilePane(init).add()