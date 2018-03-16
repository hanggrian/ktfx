@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene.control

import javafx.scene.Node
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView

inline fun <T> choiceDialog(
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = choiceDialog(null, null, items, prefill, init)

fun <T> choiceDialog(
    title: String? = null,
    graphic: Node? = null,
    items: Collection<T>? = null,
    prefill: T? = null,
    init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}