@file:JvmMultifileClass
@file:JvmName("ConvertersKt")

package kotfx.coroutines

import javafx.collections.ObservableList
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import javafx.scene.control.cell.TextFieldListCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlin.coroutines.experimental.CoroutineContext

object ChoiceBoxListCells {

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxListCell.forListView<T>(_StringConverter<T>(context).apply(converter), items)

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxListCell.forListView<T>(_StringConverter<T>(context).apply(converter), item)
}

fun <T> ChoiceBoxListCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ChoiceBoxTableCells {

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTableCell.forTableColumn<S, T>(_StringConverter<T>(context).apply(converter), items)

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTableCell.forTableColumn<S, T>(_StringConverter<T>(context).apply(converter), item)
}

fun <S, T> ChoiceBoxTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ChoiceBoxTreeCells {

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTreeCell.forTreeView<T>(_StringConverter<T>(context).apply(converter), items)

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTreeCell.forTreeView<T>(_StringConverter<T>(context).apply(converter), item)
}

fun <T> ChoiceBoxTreeCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ChoiceBoxTreeTableCells {

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTreeTableCell.forTreeTableColumn<S, T>(_StringConverter<T>(context).apply(converter), items)

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ChoiceBoxTreeTableCell.forTreeTableColumn<S, T>(_StringConverter<T>(context).apply(converter), item)
}

fun <S, T> ChoiceBoxTreeTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ComboBoxListCells {

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxListCell.forListView<T>(_StringConverter<T>(context).apply(converter), items)

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxListCell.forListView<T>(_StringConverter<T>(context).apply(converter), item)
}

fun <T> ComboBoxListCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ComboBoxTableCells {

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTableCell.forTableColumn<S, T>(_StringConverter<T>(context).apply(converter), items)

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTableCell.forTableColumn<S, T>(_StringConverter<T>(context).apply(converter), item)
}

fun <S, T> ComboBoxTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ComboBoxTreeCells {

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTreeCell.forTreeView<T>(_StringConverter<T>(context).apply(converter), items)

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTreeCell.forTreeView<T>(_StringConverter<T>(context).apply(converter), item)
}

fun <T> ComboBoxTreeCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object ComboBoxTreeTableCells {

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        items: ObservableList<T>,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTreeTableCell.forTreeTableColumn<S, T>(_StringConverter<T>(context).apply(converter), items)

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        item: T,
        converter: _StringConverter<T>.() -> Unit
    ) = ComboBoxTreeTableCell.forTreeTableColumn<S, T>(_StringConverter<T>(context).apply(converter), item)
}

fun <S, T> ComboBoxTreeTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object TextFieldListCells {

    fun <T> listView(
        context: CoroutineContext = JavaFx,
        converter: _StringConverter<T>.() -> Unit
    ) = TextFieldListCell.forListView<T>(_StringConverter<T>(context).apply(converter))
}

fun <T> TextFieldListCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object TextFieldTableCells {

    fun <S, T> tableColumn(
        context: CoroutineContext = JavaFx,
        converter: _StringConverter<T>.() -> Unit
    ) = TextFieldTableCell.forTableColumn<S, T>(_StringConverter<T>(context).apply(converter))
}

fun <S, T> TextFieldTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object TextFieldTreeCells {

    fun <T> treeView(
        context: CoroutineContext = JavaFx,
        converter: _StringConverter<T>.() -> Unit
    ) = TextFieldTreeCell.forTreeView<T>(_StringConverter<T>(context).apply(converter))
}

fun <T> TextFieldTreeCell<T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))

object TextFieldTreeTableCells {

    fun <S, T> treeTableColumn(
        context: CoroutineContext = JavaFx,
        converter: _StringConverter<T>.() -> Unit
    ) = TextFieldTreeTableCell.forTreeTableColumn<S, T>(_StringConverter<T>(context).apply(converter))
}

fun <S, T> TextFieldTreeTableCell<S, T>.converter(
    context: CoroutineContext = JavaFx,
    converter: _StringConverter<T>.() -> Unit
) = setConverter(_StringConverter<T>(context).apply(converter))