@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class _TabPane(vararg tabs: Tab) : TabPane(*tabs), LayoutManager<Tab> {

    override val childs: ObservableList<Tab> get() = tabs

    /** Convenient method to add tab to this pane by only using string. */
    inline operator fun String.invoke(graphic: Node? = null): Tab = invoke(graphic) { }

    /** Convenient method to add tab to this pane by only using string. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDsl _Tab).() -> Unit
    ): Tab = tab(this, graphic, init)
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