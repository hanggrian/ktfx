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
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return Pagination(count, index).apply(init)
}
/** Add a [Pagination] to this manager. */
fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0
): Pagination = addNode(Pagination(count, index))

/** Add a [Pagination] with initialization block to this manager. */
inline fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(Pagination(count, index), init)
}
