@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import ktfx.NodeManager
import ktfx.TabManager
import ktfx.annotations.LayoutDsl

open class _TabPane(vararg tabs: Tab) : TabPane(*tabs), TabManager {

    /** Creates a [Tab] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)
}

/** Creates a [TabPane]. */
fun tabPane(
    vararg tabs: Tab,
    init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = _TabPane(*tabs).also { init?.invoke(it) }

/** Creates a [TabPane] and add it to this manager. */
inline fun NodeManager.tabPane(
    vararg tabs: Tab,
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.tabPane(*tabs, init = init)()