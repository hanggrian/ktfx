@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.layout

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase
import javafx.scene.control.Tooltip
import kotfx.annotations.LayoutDsl

interface PopupManager {

    fun getItems(): ObservableList<MenuItem>

    fun <T : MenuItem> T.add(): T = apply { getItems() += this }
}

class _Menu(text: String = "", graphic: Node? = null, vararg items: MenuItem) : Menu(text, graphic, *items), PopupManager

inline fun menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = _Menu(text, graphic, *items).apply { init?.invoke(this) }
inline fun PopupManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = kotfx.layout.menu(text, graphic, *items, init = init).add()
inline fun MenuManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null): Menu = kotfx.layout.menu(text, graphic, *items, init = init).add()

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager

inline fun contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null): ContextMenu = _ContextMenu(*items).apply { init?.invoke(this) }
inline fun Control.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(kotfx.layout.contextMenu(*items, init = init))
inline fun Tab.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(kotfx.layout.contextMenu(*items, init = init))
inline fun <S, T> TableColumnBase<S, T>.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(kotfx.layout.contextMenu(*items, init = init))

inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = kotfx.layout.checkMenuItem(text, graphic, init).add()

inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = kotfx.layout.customMenuItem(node, hideOnClick, init).add()

inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = kotfx.layout.menuItem(text, graphic, init).add()

inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = kotfx.layout.radioMenuItem(text, graphic, init).add()

inline fun separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
inline fun PopupManager.separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = kotfx.layout.separatorMenuItem(init).add()

inline fun tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
inline fun Node.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = Tooltip.install(this, kotfx.layout.tooltip(text, init))
inline fun Control.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = setTooltip(kotfx.layout.tooltip(text, init))
inline fun Tab.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = setTooltip(kotfx.layout.tooltip(text, init))