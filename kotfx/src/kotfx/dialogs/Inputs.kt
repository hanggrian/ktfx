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
    if (title != null) {
        setTitle(title)
        setHeaderText(title)
    }
    if (graphic != null) {
        if (graphic is ImageView) icon = graphic.image
        setGraphic(graphic)
    }
    init?.invoke(this)
}