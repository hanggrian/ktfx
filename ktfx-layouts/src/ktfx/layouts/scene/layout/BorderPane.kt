@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _BorderPane : BorderPane(), LayoutManager<Node>, AlignedPane, MarginedPane {

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override fun Node.clear() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun borderPane(): BorderPane = borderPane { }

inline fun borderPane(
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = _BorderPane().apply(init)

inline fun LayoutManager<Node>.borderPane(): BorderPane = borderPane { }

inline fun LayoutManager<Node>.borderPane(
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = ktfx.layouts.borderPane(init).add()