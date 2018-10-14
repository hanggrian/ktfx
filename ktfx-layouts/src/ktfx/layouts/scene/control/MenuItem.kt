@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.MenuItem
import ktfx.MenuItemManager
import ktfx.annotations.LayoutDsl

/** Creates a [MenuItem]. */
fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).also { init?.invoke(it) }

/** Creates a [MenuItem] and add it to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = ktfx.layouts.menuItem(text, graphic, init)()