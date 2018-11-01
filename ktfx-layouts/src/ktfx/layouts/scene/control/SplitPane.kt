@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane
import ktfx.NodeManager
import ktfx.LayoutDsl

open class _SplitPane : SplitPane(), NodeManager {

    override val collection: MutableCollection<Node> get() = items
}

/** Creates a [SplitPane]. */
fun splitPane(
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane().also { init?.invoke(it) }

/** Creates a [SplitPane] and add it to this manager. */
inline fun NodeManager.splitPane(
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(init)()