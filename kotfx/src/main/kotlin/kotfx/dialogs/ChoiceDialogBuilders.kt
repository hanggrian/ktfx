package kotfx.dialogs

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceDialog

@PublishedApi
internal class FXChoiceDialogBuilder<T>(items: Collection<T>?, prefill: T?) : ChoiceDialogBuilder<T> {

    override val instance: ChoiceDialog<T> = ChoiceDialog<T>(prefill, items)
}

interface ChoiceDialogBuilder<T> : DialogBuilder<ChoiceDialog<T>, T> {

    val items: ObservableList<T> get() = instance.items

    val selectedItemProperty: ReadOnlyObjectProperty<T> get() = instance.selectedItemProperty()
    val selected: T get() = instance.selectedItem

    fun select(item: T) = instance.setSelectedItem(item)

    val prefill: T get() = instance.defaultChoice
}