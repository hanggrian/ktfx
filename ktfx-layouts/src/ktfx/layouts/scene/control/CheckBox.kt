@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.CheckBox

/** Creates a [CheckBox]. */
fun checkBox(
    text: String? = null,
    init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also {
    init?.invoke(it)
}

/** Creates a [CheckBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = ktfx.layouts.checkBox(text, init)()