@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.Dialog
import javafx.scene.image.ImageView

@JvmOverloads
fun <R> dialog(
        title: String? = null,
        graphic: Node? = null,
        init: (Dialog<R>.() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    if (title != null) setTitle(title)
    if (graphic != null) {
        if (graphic is ImageView) icon = graphic.image
        setGraphic(graphic)
    }
    if (title != null && graphic != null) setHeaderText(title)
    init?.invoke(this)
}