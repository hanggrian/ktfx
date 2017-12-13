@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Window
import kotfx.internal.DialogDsl

class _Dialog<R> : Dialog<R>(), Dialoggable<Dialog<R>, R> {
    override val dialog: Dialog<R> get() = this
}

@JvmOverloads
inline fun <R> dialog(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = _Dialog<R>().apply {
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}

@JvmOverloads
inline fun <R> Window.dialog(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = _Dialog<R>().apply {
    initOwner(this@dialog)
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}