@file:JvmMultifileClass
@file:JvmName("EventHandlersKt")

package kotfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.ButtonBase
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBoxBase
import javafx.scene.control.ContextMenu
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.control.ListView
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.Tab
import javafx.scene.control.TableColumn
import javafx.scene.control.TableColumnBase
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun ButtonBase.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onHidden(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onHiding(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onShowing(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onShown(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onHidden(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onHiding(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onShowing(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onShown(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }

fun ContextMenu.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onCloseRequest(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onHidden(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onHiding(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onShowing(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onShown(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onScrollTo(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

fun <E : Event> Menu.eventHandler(
    context: CoroutineContext = JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun Menu.onHidden(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun Menu.onHiding(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun Menu.onShowing(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun Menu.onShown(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }

fun <E : Event> MenuItem.eventHandler(
    context: CoroutineContext = JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun MenuItem.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun MenuItem.onMenuValidation(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnMenuValidation { event -> launch(context) { action(event) } }

fun Tab.onClosed(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnClosed { event -> launch(context) { action(event) } }

fun Tab.onCloseRequest(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun Tab.onSelectionChanged(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnSelectionChanged { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditCancel(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditCommit(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TableColumn<S, T>.onEditStart(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <S, T, E : Event> TableColumnBase<S, T>.eventHandler(
    context: CoroutineContext = JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(Event) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun <S> TableView<S>.onScrollTo(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

fun <S> TableView<S>.onScrollToColumn(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TableColumn<S, *>>) -> Unit
) = setOnScrollToColumn { event -> launch(context) { action(event) } }

fun <S> TableView<S>.onSort(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(SortEvent<TableView<S>>) -> Unit
) = setOnSort { event -> launch(context) { action(event) } }

fun TextField.onAction(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T, E : Event> TreeItem<T>.eventHandler(
    context: CoroutineContext = JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(Event) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <S, T> TreeTableColumn<S, T>.onEditStart(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <T> TreeTableView<T>.onScrollTo(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }

fun <T> TreeTableView<T>.onScrollToColumn(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) = setOnScrollToColumn { event -> launch(context) { action(event) } }

fun <T> TreeTableView<T>.onSort(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(SortEvent<TreeTableView<T>>) -> Unit
) = setOnSort { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onEditCancel(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onEditCommit(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onEditStart(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onScrollTo(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }