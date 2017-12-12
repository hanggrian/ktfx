package kotfx.dialogs

import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog

@PublishedApi
internal class FXInputDialogBuilder(prefill: String?) : InputDialogBuilder {

    override val instance: TextInputDialog = TextInputDialog(prefill ?: "")
}

interface InputDialogBuilder : DialogBuilder<TextInputDialog, String> {

    val editor: TextField get() = instance.editor

    val prefill: String get() = instance.defaultValue
}