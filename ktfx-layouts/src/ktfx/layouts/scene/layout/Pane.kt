@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane(
    vararg children: Node
) : Pane(*children), LayoutManager<Node> {

    override val childs: MutableCollection<Node> get() = children
}

/** Creates a [Pane]. */
fun pane(
    vararg children: Node,
    init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = _Pane(*children).also {
    init?.invoke(it)
}

/** Creates a [Pane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = ktfx.layouts.pane(*children, init = init)()