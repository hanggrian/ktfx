package kotfx.dialogs

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceDialog
import javafx.scene.control.Dialog

@PublishedApi
internal class FXChoiceDialogBuilder<T>(items: Collection<T>?, prefill: T?) : FXDialogBuilder<T>(), ChoiceDialogBuilder<T> {

    override val t: Dialog<T> = ChoiceDialog(prefill, items)
}

interface ChoiceDialogBuilder<T> : DialogBuilder<T> {

    val items: ObservableList<T> get() = (t as ChoiceDialog).items

    val selectedItemProperty: ReadOnlyObjectProperty<T> get() = (t as ChoiceDialog).selectedItemProperty()
    val selected: T get() = (t as ChoiceDialog).selectedItem

    fun select(item: T) {
        (t as ChoiceDialog).selectedItem = item
    }

    val prefill: T get() = (t as ChoiceDialog).defaultChoice
}