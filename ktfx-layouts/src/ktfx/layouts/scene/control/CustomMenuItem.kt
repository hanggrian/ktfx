@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem

/** Create a [CustomMenuItem] with initialization block. */
inline fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply(init)

/** Add a [CustomMenuItem] to this manager. */
fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = addItem(ktfx.layouts.customMenuItem(node, hideOnClick) { })

/** Add a [CustomMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem = addItem(ktfx.layouts.customMenuItem(node, hideOnClick, init))
