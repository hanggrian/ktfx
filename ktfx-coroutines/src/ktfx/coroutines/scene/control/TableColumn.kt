package ktfx.coroutines

import javafx.scene.control.TableColumn
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** This event handler will be fired when the user cancels editing a cell. */
fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

/** This event handler will be fired when the user successfully commits their editing. */
fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

/** This event handler will be fired when the user successfully initiates editing. */
fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }