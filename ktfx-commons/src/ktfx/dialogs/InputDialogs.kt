@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView

/**
 * Build a text input dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param prefill default text.
 */
fun inputDialog(
    title: String? = null,
    graphic: Node? = null,
    prefill: String = ""
): Optional<String> = TextInputDialog(prefill).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a text input dialog with Kotlin DSL.
 *
 * @param prefill default text.
 */
inline fun inputDialog(prefill: String = ""): Optional<String> =
    inputDialog(null, null, prefill)
