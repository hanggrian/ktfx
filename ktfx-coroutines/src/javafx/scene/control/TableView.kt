@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Called when there's a request to sort the control. */
fun <S> TableView<S>.onSort(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SortEvent<TableView<S>>) -> Unit
): Unit = setOnSort { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [TableView.scrollTo]. */
fun TableView<*>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }

/**
 * Called when there's a request to scroll a column into view using [TableView.scrollToColumn] or
 * [TableView.scrollToColumnIndex].
 */
fun <S> TableView<S>.onScrollToColumn(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TableColumn<S, *>>) -> Unit
): Unit = setOnScrollToColumn { event -> GlobalScope.launch(context) { action(event) } }
