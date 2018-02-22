@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import kotfx.choiceBoxCellFactory
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <T> ListView<T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = choiceBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <T> ChoiceBoxListCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> ChoiceBoxTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <T> ChoiceBoxTreeCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> ChoiceBoxTreeTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))