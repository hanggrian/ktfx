@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane : Pane(), NodeManager {

    override fun <R : Node> R.add(): R = also { children += it }
}

/** Creates a [Pane]. */
fun pane(
    init: ((@LayoutDslMarker _Pane).() -> Unit)? = null
): Pane = _Pane().also { init?.invoke(it) }

/** Creates a [Pane] and add it to this manager. */
inline fun NodeManager.pane(
    noinline init: ((@LayoutDslMarker _Pane).() -> Unit)? = null
): Pane = ktfx.layouts.pane(init).add()