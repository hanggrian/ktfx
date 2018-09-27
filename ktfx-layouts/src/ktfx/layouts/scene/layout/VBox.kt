@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

open class _VBox(
    spacing: Double,
    vararg children: Node
) : VBox(spacing, *children), LayoutManager<Node>, VGrowedPane, MarginedPane {

    override val childs: MutableCollection<Node> get() = children

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
): VBox = ktfx.layouts.vbox(spacing, *children, init = init)()