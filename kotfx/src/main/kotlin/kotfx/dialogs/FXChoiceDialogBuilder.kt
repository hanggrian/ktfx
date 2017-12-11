package kotfx.dialogs

import javafx.beans.property.ReadOnlyObjectProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceDialog
import javafx.scene.control.Dialog

@PublishedApi
internal class FXChoiceDialogBuilder<T>(items: Collection<T>?, prefill: T?) : FXDialogBuilder<T>(), ChoiceDialogBuilder<T> {

    override val dialog: Dialog<T> = ChoiceDialog(prefill, items)

    private val choiceDialog: ChoiceDialog<T> get() = (dialog as ChoiceDialog)

    override val items: ObservableList<T> get() = choiceDialog.items

    override val selectedItemProperty: ReadOnlyObjectProperty<T> get() = choiceDialog.selectedItemProperty()

    override fun select(item: T) {
        choiceDialog.selectedItem = item
    }

    override val prefill: T get() = choiceDialog.defaultChoice
}