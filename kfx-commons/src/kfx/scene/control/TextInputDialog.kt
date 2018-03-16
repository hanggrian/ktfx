@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene.control

import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

inline fun inputDialog(
    prefill: String = "",
    noinline init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = inputDialog(null, null, prefill, init)

fun inputDialog(
    title: String? = null,
    graphic: Node? = null,
    prefill: String = "",
    init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}