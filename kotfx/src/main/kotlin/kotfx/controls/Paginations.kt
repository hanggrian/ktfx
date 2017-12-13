@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _Pagination(count: Int, index: Int) : Pagination(count, index), _Control<Pagination> {
    override val node: Pagination get() = this

    fun maxPageIndicatorCount(value: Int) = setMaxPageIndicatorCount(value)
    fun pageCount(value: Int) = setPageCount(value)
    fun currentPage(value: Int) = setCurrentPageIndex(value)
}

@JvmOverloads
inline fun paginationOf(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@ControlDsl _Pagination).() -> Unit)? = null
): Pagination = _Pagination(count, index).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@ControlDsl _Pagination).() -> Unit)? = null
): Pagination = paginationOf(count, index, init).add()