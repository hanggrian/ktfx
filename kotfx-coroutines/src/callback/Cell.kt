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

object CheckBoxListCells {

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
    ) = CheckBoxListCell.forListView<T>({ param -> runBlocking(context) { action(param) } })

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>,
        converter: _StringConverter<T>.() -> Unit
    ) = CheckBoxListCell.forListView<T>({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))
}

fun <T> CheckBoxListCell<T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(T) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

object CheckBoxTableCells {

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
    ) = CheckBoxTableCell.forTableColumn<S, T>({ param -> runBlocking(context) { action(param) } })

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
        converter: _StringConverter<T>.() -> Unit
    ) = CheckBoxTableCell.forTableColumn<S, T>({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))
}

fun <S, T> CheckBoxTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

object CheckBoxTreeCells {

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
    ) = CheckBoxTreeCell.forTreeView<T>({ param -> runBlocking(context) { action(param) } })

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>,
        converter: _StringConverter<TreeItem<T>>.() -> Unit
    ) = CheckBoxTreeCell.forTreeView<T>({ param -> runBlocking(context) { action(param) } }, _StringConverter<TreeItem<T>>(context).apply(converter))
}

fun <T> CheckBoxTreeCell<T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(TreeItem<T>) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }

object CheckBoxTreeTableCells {

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
    ) = CheckBoxTreeTableCell.forTreeTableColumn<S, T>({ param -> runBlocking(context) { action(param) } })

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        showLabel: Boolean,
        action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
    ) = CheckBoxTreeTableCell.forTreeTableColumn<S, T>({ param -> runBlocking(context) { action(param) } }, showLabel)

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>,
        converter: _StringConverter<T>.() -> Unit
    ) = CheckBoxTreeTableCell.forTreeTableColumn<S, T>({ param -> runBlocking(context) { action(param) } }, _StringConverter<T>(context).apply(converter))
}

fun <S, T> CheckBoxTreeTableCell<S, T>.selectedStateCallback(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(Int) -> ObservableValue<Boolean>
) = setSelectedStateCallback { param -> runBlocking(context) { action(param) } }