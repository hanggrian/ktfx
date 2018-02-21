@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.beans.value.ObservableValue
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.util.StringConverter

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxListCell.forListView(callback))

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: StringConverter<T>
) = setCellFactory(CheckBoxListCell.forListView(callback, converter))

