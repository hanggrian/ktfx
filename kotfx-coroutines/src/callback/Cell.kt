@file:JvmMultifileClass
@file:JvmName("CallbacksKt")

package kotfx.coroutines

import javafx.beans.value.ObservableValue
import javafx.scene.control.TreeItem
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.CheckBoxTreeTableCell
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun <T> CheckBoxListCell<T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

fun <S, T> CheckBoxTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

fun <T> CheckBoxTreeCell<T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

fun <S, T> CheckBoxTreeTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }