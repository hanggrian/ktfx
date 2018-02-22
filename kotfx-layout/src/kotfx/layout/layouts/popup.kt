@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.layout

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase
import javafx.scene.control.Tooltip
import javafx.scene.control.Tooltip.install
import kotfx.annotations.LayoutDsl

inline fun contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null): ContextMenu = _ContextMenu(*items).apply { init?.invoke(this) }
inline fun Control.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(_ContextMenu(*items).apply { init?.invoke(this) })
inline fun Tab.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(_ContextMenu(*items).apply { init?.invoke(this) })
inline fun <S, T> TableColumnBase<S, T>.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(_ContextMenu(*items).apply { init?.invoke(this) })

inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()

inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
inline fun PopupManager.separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()

inline fun tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
inline fun Node.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = install(this, Tooltip(text).apply { init?.invoke(this) })
inline fun Control.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = setTooltip(Tooltip(text).apply { init?.invoke(this) })
inline fun Tab.tooltip(text: String? = null, noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null) = setTooltip(Tooltip(text).apply { init?.invoke(this) })