@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Called when there's a request to scroll an index into view using [TreeTableView.scrollTo]. */
fun TreeTableView<*>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }

/**
 * Called when there's a request to scroll a column into view using [TreeTableView.scrollToColumn] or
 * [TreeTableView.scrollToColumnIndex].
 */
fun <T> TreeTableView<T>.onScrollToColumn(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
): Unit = setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there's a request to sort the control. */
fun <T> TreeTableView<T>.onSort(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit
): Unit = setOnSort { event -> GlobalScope.launch(context) { action(event) } }
