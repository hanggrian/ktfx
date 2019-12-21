@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Called when there's a request to sort the control. */
inline fun <S> TableView<S>.onSort(
    noinline action: (SortEvent<TableView<S>>) -> Unit
): Unit = setOnSort { event -> action(event) }

/** Called when there's a request to scroll an index into view using [TableView.scrollTo]. */
inline fun TableView<*>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> action(event) }

/**
 * Called when there's a request to scroll a column into view using [TableView.scrollToColumn] or
 * [TableView.scrollToColumnIndex].
 */
inline fun <S> TableView<S>.onScrollToColumn(
    noinline action: (ScrollToEvent<TableColumn<S, *>>) -> Unit
): Unit = setOnScrollToColumn { event -> action(event) }
