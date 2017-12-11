package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog

@PublishedApi
internal class FXInputDialogBuilder(prefill: String?) : FXDialogBuilder<String>(), InputDialogBuilder {

    override val t: Dialog<String> = TextInputDialog(prefill ?: "")
}

interface InputDialogBuilder : DialogBuilder<String> {

    val editor: TextField get() = (t as TextInputDialog).editor

    val prefill: String get() = (t as TextInputDialog).defaultValue
}