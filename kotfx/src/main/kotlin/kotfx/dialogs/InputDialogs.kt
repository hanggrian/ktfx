@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.TextInputDialog
import javafx.scene.image.Image
import kotfx.internal.DialogDsl
import java.util.*

class _InputDialog(prefill: String?) : TextInputDialog(prefill), DialogBuilder<TextInputDialog> {
    override val dialog: TextInputDialog get() = this
}

@JvmOverloads
inline fun inputDialog(
        title: String? = null,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): TextInputDialog = _InputDialog(prefill).apply {
    if (title != null) title(title)
    if (icon != null) icon(icon)
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun inputDialogWait(
        title: String? = null,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: ((@DialogDsl _InputDialog).() -> Unit)? = null
): Optional<String> = _InputDialog(prefill).apply {
    if (title != null) title(title)
    if (icon != null) icon(icon)
    init?.invoke(this)
}.showAndWait()