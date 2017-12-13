@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog
import javafx.scene.image.Image
import javafx.stage.Window
import kotfx.controls._TextInputControl
import kotfx.internal.DialogDsl

class _InputDialog(prefill: String?) : TextInputDialog(prefill), Dialoggable<TextInputDialog>, _TextInputControl<TextField> {
    override val dialog: TextInputDialog get() = this
    override val control: TextField get() = editor
}

@JvmOverloads
inline fun inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = _InputDialog(prefill).apply {
    title(title)
    if (icon != null) icon(icon)
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
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}