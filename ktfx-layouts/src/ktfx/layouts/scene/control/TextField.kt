@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TextField

/** Creates a [TextField]. */
fun textField(
    text: String = "",
    init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = TextField(text).also {
    init?.invoke(it)
}

/** Creates a [TextField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textField(
    text: String = "",
    noinline init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = ktfx.layouts.textField(text, init)()