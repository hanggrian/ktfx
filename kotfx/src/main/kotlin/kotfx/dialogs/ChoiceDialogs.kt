@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Window

@JvmOverloads
inline fun <T> choiceDialog(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        icon: Image? = null,
        noinline init: (ChoiceDialogBuilder<T>.() -> Unit)? = null
): Dialog<T> = FXChoiceDialogBuilder(items, prefill).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun <T> Window.choiceDialog(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        icon: Image? = null,
        noinline init: (ChoiceDialogBuilder<T>.() -> Unit)? = null
): Dialog<T> = FXChoiceDialogBuilder(items, prefill).apply {
    this.owner = this@choiceDialog
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t