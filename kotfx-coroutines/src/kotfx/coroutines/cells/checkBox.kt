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
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.CheckBoxTreeTableCell
import kotfx.checkBoxCellFactory
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } })

fun <T> ListView<T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(T) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } }, _StringConverter<T>(context).apply(converter))

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } })

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    showLabel: Boolean,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory(showLabel, { param -> runBlocking(context) { callback(param) } })

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } }, _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } })

fun <T> TreeView<T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>,
    converter: _StringConverter<TreeItem<T>>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } }, _StringConverter<TreeItem<T>>(context).apply(converter))

fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } })

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    showLabel: Boolean,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = checkBoxCellFactory(showLabel, { param -> runBlocking(context) { callback(param) } })

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = checkBoxCellFactory({ param -> runBlocking(context) { callback(param) } }, _StringConverter<T>(context).apply(converter))

fun <T> CheckBoxListCell<T>.selectedStateCallback(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { callback(param) } }

fun <S, T> CheckBoxTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { callback(param) } }

fun <T> CheckBoxTreeCell<T>.selectedStateCallback(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { callback(param) } }

fun <S, T> CheckBoxTreeTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { callback(param) } }