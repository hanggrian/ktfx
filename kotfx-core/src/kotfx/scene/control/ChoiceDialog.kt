@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene.control

import javafx.scene.Node
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView

inline fun <T> choiceDialog(
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = choiceDialog(null, null, items, prefill, init)

fun <T> choiceDialog(
    title: String?,
    graphic: Node?,
    items: Collection<T>? = null,
    prefill: T? = null,
    init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}