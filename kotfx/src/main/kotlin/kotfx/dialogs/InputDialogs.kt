@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.TextInputDialog
import javafx.stage.Window
import kotfx.internal.DialogDsl

@JvmOverloads
inline fun inputDialog(
        prefill: String = "",
        noinline init: ((@DialogDsl TextInputDialog).() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.inputDialog(
        prefill: String = "",
        noinline init: ((@DialogDsl TextInputDialog).() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).apply {
    initOwner(this@inputDialog)
    init?.invoke(this)
}