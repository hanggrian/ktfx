@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.TextInputDialog
import javafx.scene.image.Image
import javafx.stage.Window
import kotfx.internal.DialogDsl

class _InputDialog(prefill: String?) : TextInputDialog(prefill), _Dialogable<TextInputDialog, String> {

    override val instance: TextInputDialog get() = this

    fun text(text: String) = instance.editor.setText(text)
    fun prompt(prompt: String) = instance.editor.setPromptText(prompt)
}

@JvmOverloads
inline fun inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = _InputDialog(prefill).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}

@JvmOverloads
inline fun Window.inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = _InputDialog(prefill).apply {
    initOwner(this@inputDialog)
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}