@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import ktfx.internal.KtfxInternals.newChild
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Pagination] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.pagination(pageCount: Int = INDETERMINATE, currentPageIndex: Int = 0): Pagination =
    pagination(pageCount = pageCount, currentPageIndex = currentPageIndex) { }

/**
 * Create a [Pagination] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.pagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Pagination(pageCount, currentPageIndex),
            configuration =
                configuration
        )
    )
}

/**
 * Create a styled [Pagination].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null
): Pagination = styledPagination(
    pageCount = pageCount, currentPageIndex = currentPageIndex,
    styleClass = *styleClass, id = id
) { }

/**
 * Add a styled [Pagination] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null
): Pagination = styledPagination(
    pageCount = pageCount, currentPageIndex = currentPageIndex,
    styleClass = *styleClass, id = id
) { }

/**
 * Create a styled [Pagination] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Pagination(pageCount, currentPageIndex), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [Pagination] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Pagination(pageCount, currentPageIndex), styleClass = *styleClass,
            id =
                id,
            configuration = configuration
        )
    )
}
