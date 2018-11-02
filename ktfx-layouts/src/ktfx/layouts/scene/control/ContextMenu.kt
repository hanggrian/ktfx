@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase
import ktfx.LayoutDsl
import ktfx.MenuItemInvokable

open class _ContextMenu : ContextMenu(), MenuItemInvokable {

    override fun <R : MenuItem> R.invoke(): R = also { items += it }

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [ContextMenu]. */
fun contextMenu(
    init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = _ContextMenu().also { init?.invoke(it) }

/** Creates a [ContextMenu] and set it to this [Control]. */
inline fun Control.contextMenu(
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(init).also { contextMenu = it }

/** Creates a [ContextMenu] and set it to this [Tab]. */
inline fun Tab.contextMenu(
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(init).also { contextMenu = it }

/** Creates a [ContextMenu] and set it to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(init).also { setContextMenu(it) }