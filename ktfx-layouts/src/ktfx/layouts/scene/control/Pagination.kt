@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE

inline fun pagination(
    count: Int = INDETERMINATE,
    index: Int = 0
): Pagination = pagination(count, index) { }

inline fun pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDsl Pagination).() -> Unit
): Pagination = Pagination(count, index).apply(init)

inline fun LayoutManager<Node>.pagination(
    count: Int = INDETERMINATE,
    index: Int = 0
): Pagination = pagination(count, index) { }

inline fun LayoutManager<Node>.pagination(
    count: Int = INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDsl Pagination).() -> Unit
): Pagination = ktfx.layouts.pagination(count, index, init).add()