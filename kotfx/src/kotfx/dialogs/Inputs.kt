@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

@JvmOverloads
inline fun inputDialog(
        prefill: String = "",
        noinline init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = inputDialog(null, null, prefill, init)

@JvmOverloads
fun inputDialog(
        title: String?,
        graphic: Node?,
        prefill: String = "",
        init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).apply {
    if (title != null) setHeaderTitle(title)
    if (graphic != null) when (graphic) {
        is ImageView -> setGraphicIcon(graphic)
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}