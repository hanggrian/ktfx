@file:JvmMultifileClass
@file:JvmName("CallbacksKt")

package kotfx.coroutines

import javafx.beans.value.ObservableValue
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.control.ComboBox
import javafx.scene.control.DateCell
import javafx.scene.control.DatePicker
import javafx.scene.control.Dialog
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.Pagination
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
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ComboBox<T>.cellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ListView<T>) -> ListCell<T>
) = setCellFactory { param -> runBlocking(context) { action(param) } }

fun DatePicker.dayCellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DatePicker) -> DateCell
) = setDayCellFactory { param -> runBlocking(context) { action(param) } }

fun <R> Dialog<R>.resultConverter(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ButtonType) -> R?
) = setResultConverter { param -> runBlocking(context) { action(param) } }

fun <T> ListView<T>.cellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ListView<T>) -> ListCell<T>
) = setCellFactory { param -> runBlocking(context) { action(param) } }

fun Pagination.pageFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> Node
) = setPageFactory { param -> runBlocking(context) { action(param) } }

fun <S, T> TableColumn<S, T>.cellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableColumn<S, T>) -> TableCell<S, T>
) = setCellFactory { param -> runBlocking(context) { action(param) } }

fun <S, T> TableColumn<S, T>.cellValueFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellDataFeatures<S, T>) -> ObservableValue<T>
) = setCellValueFactory { param -> runBlocking(context) { action(param) } }

fun <S> TableView<S>.columnResizePolicy(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableView.ResizeFeatures<*>) -> Boolean
) = setColumnResizePolicy { param -> runBlocking(context) { action(param) } }

fun <S> TableView<S>.rowFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableView<S>) -> TableRow<S>
) = setRowFactory { param -> runBlocking(context) { action(param) } }

fun <S> TableView<S>.sortPolicy(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableView<S>) -> Boolean
) = setSortPolicy { param -> runBlocking(context) { action(param) } }

fun <S, T> TreeTableColumn<S, T>.cellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn<S, T>) -> TreeTableCell<S, T>
) = setCellFactory { param -> runBlocking(context) { action(param) } }

fun <S, T> TreeTableColumn<S, T>.cellValueFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellDataFeatures<S, T>) -> ObservableValue<T>
) = setCellValueFactory { param -> runBlocking(context) { action(param) } }

fun <S> TreeTableView<S>.columnResizePolicy(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableView.ResizeFeatures<*>) -> Boolean
) = setColumnResizePolicy { param -> runBlocking(context) { action(param) } }

fun <S> TreeTableView<S>.rowFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableView<S>) -> TreeTableRow<S>
) = setRowFactory { param -> runBlocking(context) { action(param) } }

fun <S> TreeTableView<S>.sortPolicy(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableView<S>) -> Boolean
) = setSortPolicy { param -> runBlocking(context) { action(param) } }

fun <T> TreeView<T>.cellFactory(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeView<T>) -> TreeCell<T>
) = setCellFactory { param -> runBlocking(context) { action(param) } }