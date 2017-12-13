@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.TextField
import javafx.scene.control.TextInputDialog
import javafx.scene.image.Image
import kotfx.controls._TextInputControl
import kotfx.internal.DialogDsl

class _InputDialog(prefill: String?) : TextInputDialog(prefill), Dialoggable<TextInputDialog>, _TextInputControl<TextField> {
    override val dialog: TextInputDialog get() = this
    override val node: TextField get() = editor
}

@JvmOverloads
inline fun inputDialogOf(
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
inline fun inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = inputDialogOf(title, prefill, icon, init).apply { show() }

@JvmOverloads
inline fun inputDialogWait(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = inputDialogOf(title, prefill, icon, init).apply { showAndWait() }