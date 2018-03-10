package kfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun TableView<*>.onScrollTo(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

fun <S> TableView<S>.onScrollToColumn(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<TableColumn<S, *>>) -> Unit
) = setOnScrollToColumn { event -> launch(context) { action(event) } }

fun <S> TableView<S>.onSort(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SortEvent<TableView<S>>) -> Unit
) = setOnSort { event -> launch(context) { action(event) } }