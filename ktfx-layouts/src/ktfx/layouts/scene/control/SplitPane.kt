@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane : SplitPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { items += it }
}

/** Creates a [SplitPane]. */
fun splitPane(
    init: ((@LayoutDslMarker _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane().also { init?.invoke(it) }

/** Creates a [SplitPane] and add it to this manager. */
inline fun NodeManager.splitPane(
    noinline init: ((@LayoutDslMarker _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(init).add()
