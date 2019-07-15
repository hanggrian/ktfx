@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

/** Creates a [MenuItem]. */
fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDslMarker MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).also { init?.invoke(it) }

/** Creates a [MenuItem] and add it to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker MenuItem).() -> Unit)? = null
): MenuItem = ktfx.layouts.menuItem(text, graphic, init).add()
