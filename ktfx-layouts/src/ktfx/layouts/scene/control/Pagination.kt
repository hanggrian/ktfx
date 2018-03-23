@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE

inline fun pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).also { init?.invoke(it) }

inline fun LayoutManager<Node>.pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null
): Pagination = ktfx.layouts.pagination(count, index, init).add()