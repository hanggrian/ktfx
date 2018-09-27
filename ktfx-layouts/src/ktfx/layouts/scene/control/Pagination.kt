@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE

/** Creates a [Pagination]. */
fun pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).also {
    init?.invoke(it)
}

/** Creates a [Pagination] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = ktfx.layouts.pagination(count, index, init)()