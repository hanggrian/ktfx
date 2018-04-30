@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _BorderPane(
    center: Node?,
    top: Node?,
    right: Node?,
    bottom: Node?,
    left: Node?
) : BorderPane(center, top, right, bottom, left), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun borderPane(
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null
): BorderPane = borderPane(center, top, right, bottom, left) { }

inline fun borderPane(
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = _BorderPane(center, top, right, bottom, left).apply(init)

inline fun LayoutManager<Node>.borderPane(
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null
): BorderPane = borderPane(center, top, right, bottom, left) { }

inline fun LayoutManager<Node>.borderPane(
    center: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: (@LayoutDsl _BorderPane).() -> Unit
): BorderPane = ktfx.layouts.borderPane(center, top, right, bottom, left, init).add()