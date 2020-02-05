@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import javafx.scene.control.cell.KtfxCellUtils
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import javafx.util.StringConverter

/** Creates a [CheckBoxTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

/** Creates a [CheckBoxTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    crossinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn({ callback(it) }, converter))

/** Creates a [CheckBoxTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    crossinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn({ callback(it) }, showLabel))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, *items))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, items))

/** Creates a [ComboBoxTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, *items))

/** Creates a [ComboBoxTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, items))

/** Creates a [ProgressBarTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

/** Creates a [TextFieldTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())

/** Creates a [TextFieldTreeTableCell] factory for use in [TreeTableColumn] controls. */
inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter()
): Unit = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter))

/** Set custom cell factory to this [TreeTableColumn]. */
inline fun <S, T> TreeTableColumn<S, T>.cellFactory(
    crossinline builderAction: KtfxTreeTableCell<S, T>.(TreeTableColumn<S, T>) -> Unit
): Unit = setCellFactory {
    val builder = KtfxTreeTableCell<S, T>()
    builder.builderAction(it)
    builder
}
