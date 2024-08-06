@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.util.StringConverter

/**
 * Sets a [CheckBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 */
inline fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

/**
 * Sets a [CheckBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param selectedPropertyProvider A provider that, given an object from `TreeItem<T>`, will return
 *   an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline selectedPropertyProvider: (TreeItem<T>) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(selectedPropertyProvider))

/**
 * Sets a [CheckBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param selectedPropertyProvider A provider that, given an object from `TreeItem<T>`, will return
 *   an `ObservableValue<Boolean>` that represents whether the given item is selected or not.
 */
inline fun <T> TreeView<T>.checkBoxCellFactory(
    converter: StringConverter<TreeItem<T>>,
    noinline selectedPropertyProvider: (TreeItem<T>) -> ObservableValue<Boolean>,
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(selectedPropertyProvider, converter))

/**
 * Sets a [ChoiceBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <T> TreeView<T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

/**
 * Sets a [ChoiceBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

/**
 * Sets a [ChoiceBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <T> TreeView<T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

/**
 * Sets a [ChoiceBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ChoiceBox] menu is showing.
 */
inline fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

/**
 * Sets a [ComboBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <T> TreeView<T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ComboBoxTreeCell.forTreeView(*items))

/**
 * Sets a [ComboBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    vararg items: T,
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, *items))

/**
 * Sets a [ComboBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <T> TreeView<T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ComboBoxTreeCell.forTreeView(items))

/**
 * Sets a [ComboBoxTreeCell] factory for use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 * @param items Zero or more items that will be shown to the user when
 *   the [javafx.scene.control.ComboBox] menu is showing.
 */
inline fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T>,
    items: ObservableList<T>,
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, items))

/** Sets a [TextFieldTreeCell] factory for use in this [TreeView]. */
inline fun TreeView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView())

/**
 * Sets a [TextFieldTreeCell] factory for use in this [TreeView].
 *
 * @param converter A string converter that, given an object of type T, will return a String that
 *   can be used to represent the object visually.
 */
inline fun <T> TreeView<T>.textFieldCellFactory(converter: StringConverter<T>): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView(converter))

/**
 * Sets a custom cell factory to use in this [TreeView].
 *
 * @param T The type of the elements contained within the [TreeView].
 * @param configuration custom initialization block that configures [KtfxListCell].
 */
fun <T> TreeView<T>.cellFactory(configuration: KtfxTreeCell<T>.(TreeView<T>) -> Unit): Unit =
    setCellFactory { KtfxTreeCell<T>().apply { configuration(it) } }

/** Custom [TreeCell] configurator class. */
class KtfxTreeCell<T> :
    TreeCell<T>(),
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
