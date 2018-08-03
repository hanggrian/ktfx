@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

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
): ToggleButton = javafxx.layouts.toggleButton(text, graphic, init)()

/** Create a styled [ToggleButton]. */
fun styledToggleButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ToggleButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledToggleButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = javafxx.layouts.styledToggleButton(styleClass, text, graphic, init)()