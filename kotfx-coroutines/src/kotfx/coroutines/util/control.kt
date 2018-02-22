@file:JvmMultifileClass
@file:JvmName("UtilsKt")

package kotfx.coroutines

import javafx.beans.value.ObservableValue
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DateCell
import javafx.scene.control.DatePicker
import javafx.scene.control.Dialog
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.Pagination
import javafx.scene.control.Slider
import javafx.scene.control.SpinnerValueFactory
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableRow
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.runBlocking
import java.time.LocalDate
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ComboBox<T>.cellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(ListView<T>) -> ListCell<T>
) = setCellFactory { param -> runBlocking(context) { callback(param) } }

fun DatePicker.dayCellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(DatePicker) -> DateCell
) = setDayCellFactory { param -> runBlocking(context) { callback(param) } }

fun <R> Dialog<R>.resultConverter(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(ButtonType) -> R?
) = setResultConverter { param -> runBlocking(context) { callback(param) } }

fun <T> ListView<T>.cellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(ListView<T>) -> ListCell<T>
) = setCellFactory { param -> runBlocking(context) { callback(param) } }

fun Pagination.pageFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(Int) -> Node
) = setPageFactory { param -> runBlocking(context) { callback(param) } }

fun <S, T> TableColumn<S, T>.cellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TableColumn<S, T>) -> TableCell<S, T>
) = setCellFactory { param -> runBlocking(context) { callback(param) } }

fun <S, T> TableColumn<S, T>.cellValueFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TableColumn.CellDataFeatures<S, T>) -> ObservableValue<T>
) = setCellValueFactory { param -> runBlocking(context) { callback(param) } }

fun <S> TableView<S>.columnResizePolicy(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TableView.ResizeFeatures<*>) -> Boolean
) = setColumnResizePolicy { param -> runBlocking(context) { callback(param) } }

fun <S> TableView<S>.rowFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TableView<S>) -> TableRow<S>
) = setRowFactory { param -> runBlocking(context) { callback(param) } }

fun <S> TableView<S>.sortPolicy(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TableView<S>) -> Boolean
) = setSortPolicy { param -> runBlocking(context) { callback(param) } }

fun <S, T> TreeTableColumn<S, T>.cellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeTableColumn<S, T>) -> TreeTableCell<S, T>
) = setCellFactory { param -> runBlocking(context) { callback(param) } }

fun <S, T> TreeTableColumn<S, T>.cellValueFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeTableColumn.CellDataFeatures<S, T>) -> ObservableValue<T>
) = setCellValueFactory { param -> runBlocking(context) { callback(param) } }

fun <S> TreeTableView<S>.columnResizePolicy(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeTableView.ResizeFeatures<*>) -> Boolean
) = setColumnResizePolicy { param -> runBlocking(context) { callback(param) } }

fun <S> TreeTableView<S>.rowFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeTableView<S>) -> TreeTableRow<S>
) = setRowFactory { param -> runBlocking(context) { callback(param) } }

fun <S> TreeTableView<S>.sortPolicy(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeTableView<S>) -> Boolean
) = setSortPolicy { param -> runBlocking(context) { callback(param) } }

fun <T> TreeView<T>.cellFactory(
    context: CoroutineContext = FX,
    callback: suspend CoroutineScope.(TreeView<T>) -> TreeCell<T>
) = setCellFactory { param -> runBlocking(context) { callback(param) } }

fun <T> ChoiceBox<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <T> ComboBox<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun DatePicker.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<LocalDate>.() -> Unit
) = setConverter(_StringConverter<LocalDate>(context).apply(converter))

fun Slider.labelFormatter(
    context: CoroutineContext = FX,
    converter: _StringConverter<Double>.() -> Unit
) = setLabelFormatter(_StringConverter<Double>(context).apply(converter))

fun <T> SpinnerValueFactory<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))