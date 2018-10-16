@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.layout.Pane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _Pane : Pane(), NodeManager {

    override val collection: MutableCollection<Node> get() = children
}

/** Creates a [Pane]. */
fun pane(
    init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = _Pane().also { init?.invoke(it) }

/** Creates a [Pane] and add it to this manager. */
inline fun NodeManager.pane(
    noinline init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = ktfx.layouts.pane(init)()