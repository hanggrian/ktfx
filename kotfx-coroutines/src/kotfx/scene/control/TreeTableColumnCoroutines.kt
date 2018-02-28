package kotfx.scene.control

import javafx.scene.control.TreeTableColumn
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditStart(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }