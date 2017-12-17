@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.Dialog
import javafx.stage.Window
import kotfx.internal.DialogDsl

@JvmOverloads
inline fun <R> dialog(
        title: String,
        headerText: String? = null,
        graphic: Node? = null,
        noinline init: ((@DialogDsl Dialog<R>).() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    setTitle(title)
    headerText?.let { setHeaderText(it) }
    graphic?.let { setGraphic(it) }
    init?.invoke(this)
}

@JvmOverloads
inline fun <R> Window.dialog(
        title: String,
        headerText: String? = null,
        graphic: Node? = null,
        noinline init: ((@DialogDsl Dialog<R>).() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    initOwner(this@dialog)
    setTitle(title)
    headerText?.let { setHeaderText(it) }
    graphic?.let { setGraphic(it) }
    init?.invoke(this)
}