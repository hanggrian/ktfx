package kotfx.dialogs

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.collections.ObservableList

interface ChoiceDialogBuilder<T> : DialogBuilder<T> {

    val items: ObservableList<T>

    val selectedItemProperty: ReadOnlyObjectProperty<T>
    val selected: T get() = selectedItemProperty.get()

    fun select(item: T)

    val prefill: T
}