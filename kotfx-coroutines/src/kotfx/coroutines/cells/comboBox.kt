@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import kotfx.comboBoxCellFactory
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <T> ListView<T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(*items, converter = _StringConverter<T>(context).apply(converter))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    context: CoroutineContext = FX,
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = comboBoxCellFactory(items, _StringConverter<T>(context).apply(converter))

fun <T> ComboBoxListCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> ComboBoxTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <T> ComboBoxTreeCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> ComboBoxTreeTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))