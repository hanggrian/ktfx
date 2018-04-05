@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem

class _MenuBar(vararg menus: Menu) : MenuBar(*menus), LayoutManager<Menu> {

    override val childs: ObservableList<Menu> get() = menus

    /** Convenient method to add menu to this bar by only using string. */
    inline operator fun String.invoke(graphic: Node? = null, vararg items: MenuItem): Menu = invoke(graphic, *items) { }

    /** Convenient method to add menu to this bar by only using string. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        vararg items: MenuItem,
        init: (@LayoutDsl Menu).() -> Unit
    ): Menu = menu(this, graphic, *items, init = init)
}

inline fun menuBar(
    vararg menus: Menu
): MenuBar = menuBar(*menus) { }

inline fun menuBar(
    vararg menus: Menu,
    init: (@LayoutDsl _MenuBar).() -> Unit
): MenuBar = _MenuBar(*menus).apply(init)

inline fun LayoutManager<Node>.menuBar(
    vararg menus: Menu
): MenuBar = menuBar(*menus) { }

inline fun LayoutManager<Node>.menuBar(
    vararg menus: Menu,
    init: (@LayoutDsl _MenuBar).() -> Unit
): MenuBar = ktfx.layouts.menuBar(*menus, init = init).add()