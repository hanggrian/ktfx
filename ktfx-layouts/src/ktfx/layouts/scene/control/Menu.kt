@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

@Suppress("ClassName")
open class _Menu(text: String = "", graphic: Node? = null, vararg items: MenuItem) : Menu(text, graphic, *items), PopupManager

inline fun menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = _Menu(text, graphic, *items).apply { init?.invoke(this) }
inline fun PopupManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = ktfx.layouts.menu(text, graphic, *items, init = init).add()
inline fun MenuManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = ktfx.layouts.menu(text, graphic, *items, init = init).add()