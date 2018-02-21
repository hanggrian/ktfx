@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.beans.value.ObservableValue
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import kotfx.checkBoxCellFactory
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } })

fun <T> ListView<T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } })

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    showLabel: Boolean
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, showLabel)

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } })

fun <T> TreeView<T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>,
    converter: _StringConverter<TreeItem<T>>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, _StringConverter<TreeItem<T>>(context).apply(converter))

fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } })

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    showLabel: Boolean
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, showLabel)

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))