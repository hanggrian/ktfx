@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Label

/** Creates a [Label]. */
fun label(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [Label] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.label(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = ktfx.layouts.label(text, graphic, init)()