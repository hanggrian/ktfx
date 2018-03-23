@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

@Suppress("ClassName")
open class _TabPane(vararg tabs: Tab) : TabPane(*tabs), TabLayoutManager

inline fun tabPane(
    vararg tabs: Tab,
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = _TabPane(*tabs).also { init?.invoke(it) }

inline fun LayoutManager<Node>.tabPane(
    vararg tabs: Tab,
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.tabPane(*tabs, init = init).add()