package kotfx.dialogs

import javafx.scene.control.TextField

interface InputDialogBuilder : DialogBuilder<String> {

    val editor: TextField

    val prefill: String
}