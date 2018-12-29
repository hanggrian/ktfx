@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar

open class _ToolBar : ToolBar(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { items += it }
}

/** Creates a [ToolBar]. */
fun toolBar(
    init: ((@LayoutMarker _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar().also { init?.invoke(it) }

/** Creates a [ToolBar] and add it to this manager. */
inline fun NodeInvokable.toolBar(
    noinline init: ((@LayoutMarker _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.toolBar(init)()