@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

@Suppress("ClassName")
class _MenuBar(vararg menus: Menu) : MenuBar(*menus), LayoutManager<Menu> {

    override fun <T : Menu> T.add(): T = also { menus += it }
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