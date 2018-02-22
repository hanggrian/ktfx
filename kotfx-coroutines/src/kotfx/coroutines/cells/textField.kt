@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.TextFieldListCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import kotfx.textFieldCellFactory
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.textFieldCellFactory(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = textFieldCellFactory(_StringConverter<T>(context).apply(converter))

fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = textFieldCellFactory(_StringConverter<T>(context).apply(converter))

fun <T> TreeView<T>.textFieldCellFactory(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = textFieldCellFactory(_StringConverter<T>(context).apply(converter))

fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = textFieldCellFactory(_StringConverter<T>(context).apply(converter))

fun <T> TextFieldListCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> TextFieldTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <T> TextFieldTreeCell<T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

fun <S, T> TextFieldTreeTableCell<S, T>.converter(
    context: CoroutineContext = FX,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))