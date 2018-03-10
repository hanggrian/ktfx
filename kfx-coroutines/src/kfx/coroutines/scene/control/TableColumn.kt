package kfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.TableColumn
import javafx.scene.control.TableColumnBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> TableColumnBase<*, *>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(Event) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }