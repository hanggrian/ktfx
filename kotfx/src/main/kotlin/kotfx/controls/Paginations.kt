@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun paginationOf(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@ControlDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@ControlDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@ControlDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()