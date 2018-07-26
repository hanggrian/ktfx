@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.MenuItem

/** Creates a [CustomMenuItem]. */
fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).also {
    init?.invoke(it)
}

/** Creates a [CustomMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = javafxx.layouts.customMenuItem(node, hideOnClick, init)()

/** Create a styled [CustomMenuItem]. */
fun styledCustomMenuItem(
    styleClass: String,
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CustomMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledCustomMenuItem(
    styleClass: String,
    node: Node? = null,
    hideOnClick: Boolean = true,
    noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = javafxx.layouts.styledCustomMenuItem(styleClass, node, hideOnClick, init)()