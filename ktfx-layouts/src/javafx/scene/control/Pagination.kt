@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Pagination
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Pagination] with configuration block. */
inline fun pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Pagination(pageCount, currentPageIndex).apply(configuration)
}

/** Add a [Pagination] to this manager. */
fun NodeManager.pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0
): Pagination = addChild(Pagination(pageCount, currentPageIndex))

/** Add a [Pagination] with configuration block to this manager. */
inline fun NodeManager.pagination(
    pageCount: Int = Pagination.INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Pagination(pageCount, currentPageIndex), configuration)
}
