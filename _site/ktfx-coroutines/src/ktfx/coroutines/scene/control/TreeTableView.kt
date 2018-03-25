package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Called when there's a request to scroll an index into view using [TreeTableView.scrollTo]. */
fun TreeTableView<*>.onScrollTo(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

/**
 * Called when there's a request to scroll a column into view using [TreeTableView.scrollToColumn] or
 * [TreeTableView.scrollToColumnIndex].
 */
fun <T> TreeTableView<T>.onScrollToColumn(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) = setOnScrollToColumn { event -> launch(context) { action(event) } }

/** Called when there's a request to sort the control. */
fun <T> TreeTableView<T>.onSort(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit
) = setOnSort { event -> launch(context) { action(event) } }