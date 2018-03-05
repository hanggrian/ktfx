package kotlinfx.coroutines

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableColumn.CellEditEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }