@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kotfx.layout

import javafx.collections.ObservableList
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotfx.annotations.LayoutDsl

interface MenuManager {

    fun getMenus(): ObservableList<Menu>

    fun <T : Menu> T.add(): T = apply { getMenus() += this }
}

class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuManager

inline fun menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }
inline fun ChildManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = kotfx.layout.menuBar(*menus, init = init).add()
inline fun ItemManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = kotfx.layout.menuBar(*menus, init = init).add()
inline fun ButtonManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = kotfx.layout.menuBar(*menus, init = init).add()