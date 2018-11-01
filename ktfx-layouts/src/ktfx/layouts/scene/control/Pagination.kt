@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Pagination
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [Pagination]. */
fun pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).also { init?.invoke(it) }

/** Creates a [Pagination] and add it to this manager. */
inline fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = ktfx.layouts.pagination(count, index, init)()