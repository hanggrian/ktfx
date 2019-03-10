@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class _TabPane : TabPane(), TabManager {

    override fun <R : Tab> R.add(): R = also { tabs += it }

    /** Creates a [Tab] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutMarker _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)
}

/** Creates a [TabPane]. */
fun tabPane(
    init: ((@LayoutMarker _TabPane).() -> Unit)? = null
): TabPane = _TabPane().also { init?.invoke(it) }

/** Creates a [TabPane] and add it to this manager. */
inline fun NodeManager.tabPane(
    noinline init: ((@LayoutMarker _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.tabPane(init).add()