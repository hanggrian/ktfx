@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Window

@JvmOverloads
inline fun inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: (InputDialogBuilder.() -> Unit)? = null
): Dialog<String> = FXInputDialogBuilder(prefill).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun Window.inputDialog(
        title: String,
        prefill: String? = null,
        icon: Image? = null,
        noinline init: (InputDialogBuilder.() -> Unit)? = null
): Dialog<String> = FXInputDialogBuilder(prefill).apply {
    this.owner = this@inputDialog
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t