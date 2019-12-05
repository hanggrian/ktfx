@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Pagination
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Pagination] with initialization block. */
inline fun pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0,
    init: (@LayoutsDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Pagination(pageCount, currentPageIndex).apply(init)
}

/** Add a [Pagination] to this manager. */
fun NodeManager.pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0
): Pagination = addChild(Pagination(pageCount, currentPageIndex))

/** Add a [Pagination] with initialization block to this manager. */
inline fun NodeManager.pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0,
    init: (@LayoutsDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(Pagination(pageCount, currentPageIndex), init)
}
