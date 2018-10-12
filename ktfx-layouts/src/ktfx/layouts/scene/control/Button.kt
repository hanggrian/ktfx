@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Button

/** Creates a [Button]. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).also { init?.invoke(it) }

/** Creates a [Button] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = ktfx.layouts.button(text, graphic, init)()