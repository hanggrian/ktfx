@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _StackPane : StackPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override fun Node.clear() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun stackPane(): StackPane = stackPane { }

inline fun stackPane(
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = _StackPane().apply(init)

inline fun LayoutManager<Node>.stackPane(): StackPane = stackPane { }

inline fun LayoutManager<Node>.stackPane(
    init: (@LayoutDsl _StackPane).() -> Unit
): StackPane = ktfx.layouts.stackPane(init).add()