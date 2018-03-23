@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Pagination

inline fun pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }

inline fun Manager<Node>.pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()