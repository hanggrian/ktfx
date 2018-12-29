@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem

/** Creates a [CustomMenuItem]. */
fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: ((@LayoutMarker CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).also { init?.invoke(it) }

/** Creates a [CustomMenuItem] and add it to this manager. */
inline fun MenuItemInvokable.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    noinline init: ((@LayoutMarker CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = ktfx.layouts.customMenuItem(node, hideOnClick, init)()