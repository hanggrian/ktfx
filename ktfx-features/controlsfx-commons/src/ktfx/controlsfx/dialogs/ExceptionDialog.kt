@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.ExceptionDialog

/**
 * Build an exception dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param exception message to show.
 */
fun exceptionDialog(
    title: String? = null,
    graphic: Node? = null,
    exception: Throwable
): Optional<ButtonType> = ExceptionDialog(exception).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build an exception dialog with Kotlin DSL.
 *
 * @param exception message to show.
 */
inline fun exceptionDialog(
    exception: Throwable
): Optional<ButtonType> = exceptionDialog(null, null, exception)
