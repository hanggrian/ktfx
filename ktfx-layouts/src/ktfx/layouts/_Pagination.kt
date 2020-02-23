@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [Pagination].
 */
fun styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String
): Pagination = styledPagination(pageCount = pageCount, currentPageIndex = currentPageIndex,
        styleClass = *styleClass) { }

/**
 * Add a styled [Pagination] to this manager.
 */
fun NodeManager.styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String
): Pagination = styledPagination(pageCount = pageCount, currentPageIndex = currentPageIndex,
        styleClass = *styleClass) { }

/**
 * Create a styled [Pagination] with configuration block.
 */
inline fun styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Pagination(pageCount, currentPageIndex), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [Pagination] with configuration block to this manager.
 */
inline fun NodeManager.styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Pagination(pageCount, currentPageIndex), styleClass = *styleClass,
            configuration = configuration))
}

/**
 * Add a [Pagination] to this manager.
 */
fun NodeManager.pagination(pageCount: Int = INDETERMINATE, currentPageIndex: Int = 0): Pagination =
        pagination(pageCount = pageCount, currentPageIndex = currentPageIndex) { }

/**
 * Create a [Pagination] with configuration block.
 */
inline fun pagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Pagination(pageCount, currentPageIndex), configuration = configuration)
}

/**
 * Add a [Pagination] with configuration block to this manager.
 */
inline fun NodeManager.pagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Pagination(pageCount, currentPageIndex), configuration =
            configuration))
}
