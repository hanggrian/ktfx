@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

/** Called when there's a request to sort the control. */
inline fun <T> TreeTableView<T>.onSort(
    noinline action: (SortEvent<TreeTableView<T>>) -> Unit
): Unit = setOnSort(action)

/** Called when there's a request to scroll an index into view using [TreeTableView.scrollTo]. */
inline fun TreeTableView<*>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo(action)

/**
 * Called when there's a request to scroll a column into view using [TreeTableView.scrollToColumn] or
 * [TreeTableView.scrollToColumnIndex].
 */
inline fun <T> TreeTableView<T>.onScrollToColumn(
    noinline action: (ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
): Unit = setOnScrollToColumn(action)
