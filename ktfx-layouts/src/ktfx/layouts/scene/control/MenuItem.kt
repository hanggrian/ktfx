@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

/** Add a [MenuItem] to this manager. */
fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = MenuItem(text, graphic).add()

/** Add a [MenuItem] with initialization block to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem = menuItem(text, graphic).apply(init)
