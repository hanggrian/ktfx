@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.TableColumn
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** This event handler will be fired when the user successfully initiates editing. */
fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user successfully commits their editing. */
fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user cancels editing a cell. */
fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }
