@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.KtfxCellUtils
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.util.StringConverter

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    crossinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn({ callback(it) }, converter))

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    crossinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn({ callback(it) }, showLabel))

/** Creates a [ChoiceBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

/** Creates a [ChoiceBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

/** Creates a [ComboBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, *items))

/** Creates a [ComboBoxTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, items))

/** Creates a [ProgressBarTableCell] factory for use in [TableColumn] controls. */
inline fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

/** Creates a [TextFieldTableCell] factory for use in [TableColumn] controls. */
inline fun <S> TableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn())

/** Creates a [TextFieldTableCell] factory for use in [TableColumn] controls. */
inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter()
): Unit = setCellFactory(TextFieldTableCell.forTableColumn(converter))

/** Set custom cell factory to this [TableColumn]. */
inline fun <S, T> TableColumn<S, T>.cellFactory(
    crossinline cellFactory: TableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { TableCellBuilder<S, T>().apply(cellFactory) }
