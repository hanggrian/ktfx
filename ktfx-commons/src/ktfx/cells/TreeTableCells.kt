@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import javafx.util.StringConverter

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 */
inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param selectedPropertyProvider A provider that, given an object from `TreeTableColumn<S,T>`,
 *  will return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    crossinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn { selectedPropertyProvider(it) })

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 * @param selectedPropertyProvider A provider that, given an object from `TreeTableColumn<S,T>`,
 *  will return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T>,
    crossinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn({ selectedPropertyProvider(it) }, converter))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param showLabel In some cases, it may be desirable to show a label in
 *  the TableCell beside the [javafx.scene.control.CheckBox].
 * @param selectedPropertyProvider A provider that, given an object from `TreeTableColumn<S,T>`,
 *  will return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    crossinline selectedPropertyProvider: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn({ selectedPropertyProvider(it) }, showLabel))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, *items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(*items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, *items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(items))

/**
 * Sets a [CheckBoxTreeTableCell] factory for use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when the
 *  [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, items))

/**
 * Sets a [ProgressBarTreeTableCell] factory for use in this [TreeTableColumn].
 */
inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

/**
 * Sets a [TextFieldTreeTableCell] factory for use in this [TreeTableColumn].
 */
inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())

/**
 * Sets a [TextFieldTreeTableCell] factory for use in this [TreeTableColumn].
 * @param converter A string converter that, given an object of type T,
 *  will return a String that can be used to represent the object visually.
 */
inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T>
): Unit = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter))

/**
 * Sets a custom cell factory to use in this [TreeTableColumn].
 * @param T The type of the elements contained within the [TreeTableColumn].
 * @param configuration custom initialization block that configures [TreeTableColumn].
 */
fun <S, T> TreeTableColumn<S, T>.cellFactory(
    configuration: KtfxTreeTableCell<S, T>.(TreeTableColumn<S, T>) -> Unit
): Unit = setCellFactory {
    val builder = KtfxTreeTableCell<S, T>()
    builder.configuration(it)
    builder
}

/** Custom [TreeTableCell] configurator class. */
class KtfxTreeTableCell<S, T> internal constructor() : TreeTableCell<S, T>(), KtfxCell<T> {
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
