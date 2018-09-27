@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem

/** Creates a [RadioMenuItem]. */
fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [RadioMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = ktfx.layouts.radioMenuItem(text, graphic, init)()