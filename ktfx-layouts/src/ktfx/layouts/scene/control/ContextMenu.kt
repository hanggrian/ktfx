@file:Suppress("NOTHING_TO_INLINE", "ClassName", "UsePropertyAccessSyntax")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

open class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), LayoutManager<MenuItem> {

    override val childs: ObservableList<MenuItem> get() = items
}

inline fun contextMenu(
    vararg items: MenuItem
): ContextMenu = contextMenu(*items) { }

inline fun contextMenu(
    vararg items: MenuItem,
    init: (@LayoutDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply(init)

inline fun Control.contextMenu(
    vararg items: MenuItem
) = contextMenu(*items) { }

inline fun Control.contextMenu(
    vararg items: MenuItem,
    init: (@LayoutDsl _ContextMenu).() -> Unit
) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))

inline fun Tab.contextMenu(
    vararg items: MenuItem
) = contextMenu(*items) { }

inline fun Tab.contextMenu(
    vararg items: MenuItem,
    init: (@LayoutDsl _ContextMenu).() -> Unit
) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))

inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    vararg items: MenuItem
) = contextMenu(*items) { }

inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    vararg items: MenuItem,
    init: (@LayoutDsl _ContextMenu).() -> Unit
) = setContextMenu(ktfx.layouts.contextMenu(*items, init = init))