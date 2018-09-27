@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ToggleButton

/** Creates a [ToggleButton]. */
fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [ToggleButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init)()