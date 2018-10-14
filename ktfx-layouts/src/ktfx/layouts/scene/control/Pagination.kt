@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Pagination]. */
fun pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).also { init?.invoke(it) }

/** Creates a [Pagination] and add it to this manager. */
inline fun NodeManager.pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = ktfx.layouts.pagination(count, index, init)()