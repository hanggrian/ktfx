@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.MenuItem

inline fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = customMenuItem(node, hideOnClick) { }

inline fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDsl CustomMenuItem).() -> Unit
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply(init)

inline fun LayoutManager<MenuItem>.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = customMenuItem(node, hideOnClick) { }

inline fun LayoutManager<MenuItem>.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDsl CustomMenuItem).() -> Unit
): CustomMenuItem = ktfx.layouts.customMenuItem(node, hideOnClick, init).add()