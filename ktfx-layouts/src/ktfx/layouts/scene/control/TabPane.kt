@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Tab
import javafx.scene.control.TabPane

@Suppress("ClassName")
open class _TabPane(vararg tabs: Tab) : TabPane(*tabs), TabManager

inline fun tabPane(vararg tabs: Tab, noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null): TabPane = _TabPane(*tabs).apply { init?.invoke(this) }
inline fun ChildManager.tabPane(vararg tabs: Tab, noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null): TabPane = ktfx.layouts.tabPane(*tabs, init = init).add()
inline fun ItemManager.tabPane(vararg tabs: Tab, noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null): TabPane = ktfx.layouts.tabPane(*tabs, init = init).add()
inline fun ButtonManager.tabPane(vararg tabs: Tab, noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null): TabPane = ktfx.layouts.tabPane(*tabs, init = init).add()