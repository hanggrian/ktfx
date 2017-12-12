@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Window

@JvmOverloads
inline fun <R> dialog(
        title: String,
        icon: Image? = null,
        noinline init: (DialogBuilder<Dialog<R>, R>.() -> Unit)? = null
): Dialog<R> = FXDialogBuilder<R>().apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun <R> Window.dialog(
        title: String,
        icon: Image? = null,
        noinline init: (DialogBuilder<Dialog<R>, R>.() -> Unit)? = null
): Dialog<R> = FXDialogBuilder<R>().apply {
    this.owner = this@dialog
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t