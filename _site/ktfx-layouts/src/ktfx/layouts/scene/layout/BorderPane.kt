@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

open class _BorderPane : BorderPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun borderPane(
    noinline init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = _BorderPane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.borderPane(
    noinline init: ((@LayoutDsl _BorderPane).() -> Unit)? = null
): BorderPane = ktfx.layouts.borderPane(init).add()