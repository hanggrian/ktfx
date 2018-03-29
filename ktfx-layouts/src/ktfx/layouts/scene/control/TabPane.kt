@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

@Suppress("ClassName")
open class _TabPane(vararg tabs: Tab) : TabPane(*tabs), LayoutManager<Tab> {

    override fun <T : Tab> T.add(): T = also { tabs += it }
}

inline fun tabPane(
    vararg tabs: Tab
): TabPane = tabPane(*tabs) { }

inline fun tabPane(
    vararg tabs: Tab,
    init: (@LayoutDsl _TabPane).() -> Unit
): TabPane = _TabPane(*tabs).apply(init)

inline fun LayoutManager<Node>.tabPane(
    vararg tabs: Tab
): TabPane = tabPane(*tabs) { }

inline fun LayoutManager<Node>.tabPane(
    vararg tabs: Tab,
    init: (@LayoutDsl _TabPane).() -> Unit
): TabPane = ktfx.layouts.tabPane(*tabs, init = init).add()