@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import ktfx.layouts.internal.MarginedPane
import ktfx.layouts.internal.VGrowedPane

open class _VBox(
    spacing: Double,
    vararg children: Node
) : VBox(spacing, *children), LayoutManager<Node>, VGrowedPane, MarginedPane {

    override val childs: MutableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [VBox]. */
fun vbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = _VBox(spacing, *children).also {
    init?.invoke(it)
}

/** Creates a [VBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.vbox(
    spacing: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = ktfx.layouts.vbox(spacing, *children, init = init).add()

/** Create a styled [VBox]. */
fun styledVbox(
    styleClass: String,
    spacing: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = _VBox(spacing, *children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [VBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledVbox(
    styleClass: String,
    spacing: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _VBox).() -> Unit)? = null
): VBox = ktfx.layouts.styledVbox(styleClass, spacing, *children, init = init).add()