@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.coroutines

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableColumn.CellEditEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** This event handler will be fired when the user cancels editing a cell. */
fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user successfully commits their editing. */
fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** This event handler will be fired when the user successfully initiates editing. */
fun <S, T> TreeTableColumn<S, T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(CellEditEvent<S, T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }
