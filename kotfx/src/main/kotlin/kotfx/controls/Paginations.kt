@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.pagination(
        count: Int = INDETERMINATE,
        index: Int = 0,
        noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null
): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()