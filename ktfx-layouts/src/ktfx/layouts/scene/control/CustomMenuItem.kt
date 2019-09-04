@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem

/** Add a [CustomMenuItem] to this manager. */
fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = CustomMenuItem(node, hideOnClick).add()

/** Add a [CustomMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem = customMenuItem(node, hideOnClick).apply(init)
