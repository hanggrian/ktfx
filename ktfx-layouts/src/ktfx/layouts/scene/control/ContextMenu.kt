@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

open class _ContextMenu : ContextMenu(), MenuItemManager {

    override fun <R : MenuItem> R.add(): R = also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Set a [ContextMenu] to this [Control]. */
fun Control.contextMenu(): ContextMenu =
    _ContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Control]. */
inline fun Control.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = (contextMenu() as _ContextMenu).apply(init).also { contextMenu = it }

/** Set a [ContextMenu] to this [Tab]. */
fun Tab.contextMenu(): ContextMenu =
    _ContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Tab]. */
inline fun Tab.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = (contextMenu() as _ContextMenu).apply(init).also { contextMenu = it }

/** Set a [ContextMenu] to this [TableColumnBase]. */
fun <S, T> TableColumnBase<S, T>.contextMenu(): ContextMenu =
    _ContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = (contextMenu() as _ContextMenu).apply(init).also { contextMenu = it }
