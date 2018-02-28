package kotfx.scene.control

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> TreeTableView<T>.onScrollTo(
    context: CoroutineContext,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

fun <T> TreeTableView<T>.onScrollToColumn(
    context: CoroutineContext,
    action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) = setOnScrollToColumn { event -> launch(context) { action(event) } }

fun <T> TreeTableView<T>.onSort(
    context: CoroutineContext,
    action: suspend CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit
) = setOnSort { event -> launch(context) { action(event) } }