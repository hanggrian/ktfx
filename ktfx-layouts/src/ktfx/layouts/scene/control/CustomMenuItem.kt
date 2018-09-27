@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

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
): CustomMenuItem = ktfx.layouts.customMenuItem(node, hideOnClick, init)()