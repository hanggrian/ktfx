@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell
import javafx.util.StringConverter

/**
 * Sets a [CheckBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param selectedPropertyProvider A provider that, given an object from `ListView<T>.items`, will
 *   return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
public inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline selectedPropertyProvider: (T) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxListCell.forListView(selectedPropertyProvider))

/**
 * Sets a [CheckBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param selectedPropertyProvider A provider that, given an object from `ListView<T>.items`, will
 *   return an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
public inline fun <T> ListView<T>.checkBoxCellFactory(
    converter: StringConverter<T>,
    noinline selectedPropertyProvider: (T) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxListCell.forListView(selectedPropertyProvider, converter))

/**
 * Sets a [ChoiceBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
public inline fun <T> ListView<T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxListCell.forListView(*items))

/**
 * Sets a [ChoiceBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
public inline fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, *items))

/**
 * Sets a [ChoiceBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
public inline fun <T> ListView<T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxListCell.forListView(items))

/**
 * Sets a [ChoiceBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
public inline fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, items))

/**
 * Sets a [ComboBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
public inline fun <T> ListView<T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ComboBoxListCell.forListView(*items))

/**
 * Sets a [ComboBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
public inline fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, *items))

/**
 * Sets a [ComboBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
public inline fun <T> ListView<T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ComboBoxListCell.forListView(items))

/**
 * Sets a [ComboBoxListCell] factory for use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
public inline fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, items))

/** Sets a [TextFieldListCell] factory for use in this [ListView]. */
public inline fun ListView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldListCell.forListView())

/**
 * Sets a [TextFieldListCell] factory for use in this [ListView].
 *
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 */
public inline fun <T> ListView<T>.textFieldCellFactory(converter: StringConverter<T>): Unit =
    setCellFactory(TextFieldListCell.forListView(converter))

/**
 * Sets a custom cell factory to use in this [ListView].
 *
 * @param T The type of the elements contained within the [ListView].
 * @param configuration custom initialization block that configures [KtfxListCell].
 */
public fun <T> ListView<T>.cellFactory(configuration: KtfxListCell<T>.(ListView<T>) -> Unit): Unit =
    setCellFactory { KtfxListCell<T>().apply { configuration(it) } }

/**
 * Sets a custom cell factory to use in this [ComboBox].
 *
 * @param T The type of the elements contained within the [ComboBox].
 * @param configuration custom initialization block that configures [KtfxListCell].
 */
public fun <T> ComboBox<T>.cellFactory(configuration: KtfxListCell<T>.(ListView<T>) -> Unit): Unit =
    setCellFactory { KtfxListCell<T>().apply { configuration(it) } }

/** Custom [ListCell] configurator class. */
public class KtfxListCell<T> :
    ListCell<T>(),
    KtfxCell<T> {
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
