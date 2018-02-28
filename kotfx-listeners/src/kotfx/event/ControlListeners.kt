@file:Suppress("NOTHING_TO_INLINE")

package kotfx.event

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

inline fun ButtonBase.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun <T> ChoiceBox<T>.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun <T> ChoiceBox<T>.onHidden(
    noinline action: (Event) -> Unit
) = setOnHidden { event -> action(event) }

inline fun <T> ChoiceBox<T>.onHiding(
    noinline action: (Event) -> Unit
) = setOnHiding { event -> action(event) }

inline fun <T> ChoiceBox<T>.onShowing(
    noinline action: (Event) -> Unit
) = setOnShowing { event -> action(event) }

inline fun <T> ChoiceBox<T>.onShown(
    noinline action: (Event) -> Unit
) = setOnShown { event -> action(event) }

inline fun <T> ComboBoxBase<T>.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun <T> ComboBoxBase<T>.onHidden(
    noinline action: (Event) -> Unit
) = setOnHidden { event -> action(event) }

inline fun <T> ComboBoxBase<T>.onHiding(
    noinline action: (Event) -> Unit
) = setOnHiding { event -> action(event) }

inline fun <T> ComboBoxBase<T>.onShowing(
    noinline action: (Event) -> Unit
) = setOnShowing { event -> action(event) }

inline fun <T> ComboBoxBase<T>.onShown(
    noinline action: (Event) -> Unit
) = setOnShown { event -> action(event) }

inline fun ContextMenu.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun <R> Dialog<R>.onCloseRequest(
    noinline action: (DialogEvent) -> Unit
) = setOnCloseRequest { event -> action(event) }

inline fun <R> Dialog<R>.onHidden(
    noinline action: (DialogEvent) -> Unit
) = setOnHidden { event -> action(event) }

inline fun <R> Dialog<R>.onHiding(
    noinline action: (DialogEvent) -> Unit
) = setOnHiding { event -> action(event) }

inline fun <R> Dialog<R>.onShowing(
    noinline action: (DialogEvent) -> Unit
) = setOnShowing { event -> action(event) }

inline fun <R> Dialog<R>.onShown(
    noinline action: (DialogEvent) -> Unit
) = setOnShown { event -> action(event) }

inline fun <T> ListView<T>.onEditCancel(
    noinline action: (ListView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> action(event) }

inline fun <T> ListView<T>.onEditCommit(
    noinline action: (ListView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> action(event) }

inline fun <T> ListView<T>.onEditStart(
    noinline action: (ListView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> action(event) }

inline fun <T> ListView<T>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> action(event) }

inline fun <E : Event> Menu.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun Menu.onHidden(
    noinline action: (Event) -> Unit
) = setOnHidden { event -> action(event) }

inline fun Menu.onHiding(
    noinline action: (Event) -> Unit
) = setOnHiding { event -> action(event) }

inline fun Menu.onShowing(
    noinline action: (Event) -> Unit
) = setOnShowing { event -> action(event) }

inline fun Menu.onShown(
    noinline action: (Event) -> Unit
) = setOnShown { event -> action(event) }

inline fun <E : Event> MenuItem.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun MenuItem.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun MenuItem.onMenuValidation(
    noinline action: (Event) -> Unit
) = setOnMenuValidation { event -> action(event) }

inline fun Tab.onClosed(
    noinline action: (Event) -> Unit
) = setOnClosed { event -> action(event) }

inline fun Tab.onCloseRequest(
    noinline action: (Event) -> Unit
) = setOnCloseRequest { event -> action(event) }

inline fun Tab.onSelectionChanged(
    noinline action: (Event) -> Unit
) = setOnSelectionChanged { event -> action(event) }

inline fun <S, T> TableColumn<S, T>.onEditCancel(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> action(event) }

inline fun <S, T> TableColumn<S, T>.onEditCommit(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> action(event) }

inline fun <S, T> TableColumn<S, T>.onEditStart(
    noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> action(event) }

inline fun <S, T, E : Event> TableColumnBase<S, T>.eventHandler(
    type: EventType<E>,
    noinline action: (Event) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun <S> TableView<S>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> action(event) }

inline fun <S> TableView<S>.onScrollToColumn(
    noinline action: (ScrollToEvent<TableColumn<S, *>>) -> Unit
) = setOnScrollToColumn { event -> action(event) }

inline fun <S> TableView<S>.onSort(
    noinline action: (SortEvent<TableView<S>>) -> Unit
) = setOnSort { event -> action(event) }

inline fun TextField.onAction(
    noinline action: (ActionEvent) -> Unit
) = setOnAction { event -> action(event) }

inline fun <T, E : Event> TreeItem<T>.eventHandler(
    type: EventType<E>,
    noinline action: (Event) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun <S, T> TreeTableColumn<S, T>.onEditCancel(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCancel { event -> action(event) }

inline fun <S, T> TreeTableColumn<S, T>.onEditCommit(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditCommit { event -> action(event) }

inline fun <S, T> TreeTableColumn<S, T>.onEditStart(
    noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit
) = setOnEditStart { event -> action(event) }

inline fun <T> TreeTableView<T>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> action(event) }

inline fun <T> TreeTableView<T>.onScrollToColumn(
    noinline action: (ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) = setOnScrollToColumn { event -> action(event) }

inline fun <T> TreeTableView<T>.onSort(
    noinline action: (SortEvent<TreeTableView<T>>) -> Unit
) = setOnSort { event -> action(event) }

inline fun <T> TreeView<T>.onEditCancel(
    noinline action: (TreeView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> action(event) }

inline fun <T> TreeView<T>.onEditCommit(
    noinline action: (TreeView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> action(event) }

inline fun <T> TreeView<T>.onEditStart(
    noinline action: (TreeView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> action(event) }

inline fun <T> TreeView<T>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> action(event) }