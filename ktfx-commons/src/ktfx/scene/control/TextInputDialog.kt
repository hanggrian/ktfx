@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.control

import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

/**
 * Build a text input dialog with Kotlin DSL.
 *
 * @param prefill default text.
 * @param init custom initialization block.
 */
inline fun inputDialog(
    prefill: String = "",
    noinline init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = inputDialog(null, null, prefill, init)

/**
 * Build a text input dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param prefill default text.
 * @param init custom initialization block.
 */
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