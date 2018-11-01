@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import ktfx.LayoutDsl
import ktfx.NodeManager

open class _SplitPane : SplitPane(), NodeManager {

    override fun <R : Node> R.invoke(): R = also { items += it }
}

/** Creates a [SplitPane]. */
fun splitPane(
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane().also { init?.invoke(it) }

/** Creates a [SplitPane] and add it to this manager. */
inline fun NodeManager.splitPane(
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(init)()