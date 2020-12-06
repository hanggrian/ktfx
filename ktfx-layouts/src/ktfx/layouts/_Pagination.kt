@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

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

/**
 * Add a [Pagination] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.pagination(pageCount: Int = INDETERMINATE, currentPageIndex: Int = 0):
    Pagination = pagination(pageCount = pageCount, currentPageIndex = currentPageIndex) { }

/**
 * Create a [Pagination] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun pagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@KtfxLayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Pagination(pageCount, currentPageIndex)
    child.configuration()
    return child
}

/**
 * Add a [Pagination] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.pagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    configuration: (@KtfxLayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Pagination(pageCount, currentPageIndex)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Pagination].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledPagination(
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
public fun NodeManager.styledPagination(
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
public inline fun styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Pagination(pageCount, currentPageIndex)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Pagination] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledPagination(
    pageCount: Int = INDETERMINATE,
    currentPageIndex: Int = 0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Pagination).() -> Unit
): Pagination {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Pagination(pageCount, currentPageIndex)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
