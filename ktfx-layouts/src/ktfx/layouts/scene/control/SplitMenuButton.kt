@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

inline fun splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }
inline fun ChildManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()
inline fun ItemManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()
inline fun ButtonManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()