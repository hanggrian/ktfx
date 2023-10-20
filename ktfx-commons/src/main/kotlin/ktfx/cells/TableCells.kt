@file:Suppress("NOTHING_TO_INLINE", "ktlint:rulebook:rename-uncommon-generics")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.util.StringConverter

/** Sets a [CheckBoxTableCell] factory for use in this [TableColumn]. */
inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

/**
 * Sets a [CheckBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param selectedPropertyProvider A provider that, given an object from `TableColumn<S,T>`, will
 *   return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(selectedPropertyProvider))

/**
 * Sets a [CheckBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param selectedPropertyProvider A provider that, given an object from `TableColumn<S,T>`, will
 *   return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T>,
    noinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(selectedPropertyProvider, converter))

/**
 * Sets a [CheckBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param showLabel In some cases, it may be desirable to show a label in the TableCell beside
 *   the [javafx.scene.control.CheckBox].
 * @param selectedPropertyProvider A provider that, given an object from `TableColumn<S,T>`, will
 *   return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(selectedPropertyProvider, showLabel))

/**
 * Sets a [CheckBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

/**
 * Sets a [ChoiceBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

/**
 * Sets a [ChoiceBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

/**
 * Sets a [ChoiceBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

/**
 * Sets a [ComboBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ComboBoxTableCell.forTableColumn(*items))

/**
 * Sets a [ComboBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, *items))

/**
 * Sets a [ComboBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ComboBoxTableCell.forTableColumn(items))

/**
 * Sets a [ComboBoxTableCell] factory for use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, items))

/** Sets a [ProgressBarTableCell] factory for use in this [TableColumn]. */
inline fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

/** Sets a [TextFieldTableCell] factory for use in this [TableColumn]. */
inline fun <S> TableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn())

/**
 * Sets a [TextFieldTableCell] factory for use in this [TableColumn].
 *
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 */
inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(converter: StringConverter<T>): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn(converter))

/**
 * Sets a custom cell factory to use in this [TableColumn].
 *
 * @param T The type of the elements contained within the [TableColumn].
 * @param configuration custom initialization block that configures [KtfxTableCell].
 */
fun <S, T> TableColumn<S, T>.cellFactory(
    configuration: KtfxTableCell<S, T>.(TableColumn<S, T>) -> Unit,
): Unit = setCellFactory { KtfxTableCell<S, T>().apply { configuration(it) } }

/** Custom [TableCell] configurator class. */
class KtfxTableCell<S, T> : TableCell<S, T>(), KtfxCell<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}
