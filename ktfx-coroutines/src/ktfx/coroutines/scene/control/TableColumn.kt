@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.scene.control.TableColumn
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** This event handler will be fired when the user cancels editing a cell. */
fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user successfully commits their editing. */
fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user successfully initiates editing. */
fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }