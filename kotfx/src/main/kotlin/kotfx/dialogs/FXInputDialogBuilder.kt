package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog

@PublishedApi
internal class FXInputDialogBuilder(prefill: String?) : FXDialogBuilder<String>(), InputDialogBuilder {

    override val dialog: Dialog<String> = TextInputDialog(prefill ?: "")

    private val inputDialog: TextInputDialog get() = (dialog as TextInputDialog)

    override val editor: TextField get() = inputDialog.editor

    override val prefill: String get() = inputDialog.defaultValue
}