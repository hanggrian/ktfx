package kotfx.dialogs

import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog

@PublishedApi
internal class FXInputDialogBuilder(prefill: String?) : InputDialogBuilder {

    override val t: TextInputDialog = TextInputDialog(prefill ?: "")
}

interface InputDialogBuilder : DialogBuilder<TextInputDialog, String> {

    val editor: TextField get() = t.editor

    val prefill: String get() = t.defaultValue
}