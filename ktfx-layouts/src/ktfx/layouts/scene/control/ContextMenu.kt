@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.layouts

import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

@Suppress("ClassName")
open class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager

inline fun contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null): ContextMenu = _ContextMenu(*items).apply { init?.invoke(this) }

inline fun Control.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))

inline fun Tab.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))

inline fun <S, T> TableColumnBase<S, T>.contextMenu(vararg items: MenuItem, noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))