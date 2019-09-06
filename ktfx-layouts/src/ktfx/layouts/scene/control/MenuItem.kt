@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

/** Create a [MenuItem] with initialization block. */
inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem = MenuItem(text, graphic).apply(init)

/** Add a [MenuItem] to this manager. */
fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = addItem(ktfx.layouts.menuItem(text, graphic) { })

/** Add a [MenuItem] with initialization block to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem = addItem(ktfx.layouts.menuItem(text, graphic, init))
