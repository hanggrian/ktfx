@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane : SplitPane(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { items += it }
}

/** Creates a [SplitPane]. */
fun splitPane(
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane().also { init?.invoke(it) }

/** Creates a [SplitPane] and add it to this manager. */
inline fun NodeInvokable.splitPane(
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(init)()