@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

@Suppress("ClassName")
class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuManager

inline fun menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }
inline fun ChildManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = ktfx.layouts.menuBar(*menus, init = init).add()
inline fun ItemManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = ktfx.layouts.menuBar(*menus, init = init).add()
inline fun ButtonManager.menuBar(vararg menus: Menu, noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null): MenuBar = ktfx.layouts.menuBar(*menus, init = init).add()