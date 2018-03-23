@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Pagination

inline fun pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }
inline fun ChildManager.pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()
inline fun ItemManager.pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()
inline fun ButtonManager.pagination(count: Int = Pagination.INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()