@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene.control

import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

inline fun inputDialog(
    prefill: String = "",
    noinline init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = inputDialog(null, null, prefill, init)

fun inputDialog(
    title: String?,
    graphic: Node?,
    prefill: String = "",
    init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}