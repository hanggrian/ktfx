@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

open class _ContextMenu : ContextMenu(), MenuItemManager {

    override fun <T : MenuItem> addItem(item: T): T = item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [ContextMenu] with initialization block. */
inline fun contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu().apply(init)

/** Set a [ContextMenu] to this [Control]. */
fun Control.contextMenu(): ContextMenu =
    ktfx.layouts.contextMenu { }.also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Control]. */
inline fun Control.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = ktfx.layouts.contextMenu(init).also { contextMenu = it }

/** Set a [ContextMenu] to this [Tab]. */
fun Tab.contextMenu(): ContextMenu =
    ktfx.layouts.contextMenu { }.also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Tab]. */
inline fun Tab.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = ktfx.layouts.contextMenu(init).also { contextMenu = it }

/** Set a [ContextMenu] to this [TableColumnBase]. */
fun <S, T> TableColumnBase<S, T>.contextMenu(): ContextMenu =
    ktfx.layouts.contextMenu { }.also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    init: (@LayoutDslMarker _ContextMenu).() -> Unit
): ContextMenu = ktfx.layouts.contextMenu(init).also { contextMenu = it }
