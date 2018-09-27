@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Spinner

/** Creates a [Spinner]. */
fun <T> spinner(
    init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().also {
    init?.invoke(it)
}

/** Creates a [Spinner] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.spinner(
    noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = ktfx.layouts.spinner(init)()