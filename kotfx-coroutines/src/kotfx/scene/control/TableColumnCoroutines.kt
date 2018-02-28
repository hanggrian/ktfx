package kotfx.scene.control

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.TableColumn
import javafx.scene.control.TableColumnBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <S, T, E : Event> TableColumnBase<S, T>.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(Event) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }