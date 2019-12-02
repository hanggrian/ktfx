@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

/**
 * Show a text input dialog with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param prefill default text.
 * @param builderAction custom dialog builder action.
 * @return input text
 */
fun inputDialog(
    title: String? = null,
    graphic: Node? = null,
    prefill: String = "",
    builderAction: (TextInputDialog.() -> Unit)? = null
): Optional<String> = TextInputDialog(prefill).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    builderAction?.invoke(dialog)
}.showAndWait()

/**
 * Show a text input dialog.
 *
 * @param prefill default text.
 * @param builderAction custom dialog builder action.
 * @return input text
 */
inline fun inputDialog(
    prefill: String = "",
    noinline builderAction: (TextInputDialog.() -> Unit)? = null
): Optional<String> = inputDialog(null, null, prefill, builderAction)
