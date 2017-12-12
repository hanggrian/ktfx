package kotfx.dialogs

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceDialog

@PublishedApi
internal class FXChoiceDialogBuilder<T>(items: Collection<T>?, prefill: T?) : ChoiceDialogBuilder<T> {

    override val t: ChoiceDialog<T> = ChoiceDialog<T>(prefill, items)
}

interface ChoiceDialogBuilder<T> : DialogBuilder<ChoiceDialog<T>, T> {

    val items: ObservableList<T> get() = t.items

    val selectedItemProperty: ReadOnlyObjectProperty<T> get() = t.selectedItemProperty()
    val selected: T get() = t.selectedItem

    fun select(item: T) = t.setSelectedItem(item)

    val prefill: T get() = t.defaultChoice
}