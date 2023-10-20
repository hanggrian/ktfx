@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.ExceptionDialog
import java.util.Optional

/**
 * Build an exception dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param exception message to show.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
fun exceptionDialog(
    title: String? = null,
    graphic: Node? = null,
    exception: Throwable,
    dialogAction: (ExceptionDialog.() -> Unit)? = null,
): Optional<ButtonType> =
    ExceptionDialog(exception).also { dialog ->
        if (title != null) dialog.headerTitle = title
        when {
            graphic is ImageView -> dialog.graphicIcon = graphic
            graphic != null -> dialog.graphic = graphic
        }
        dialogAction?.invoke(dialog)
    }.showAndWait()

/**
 * Build an exception dialog with Kotlin DSL.
 *
 * @param exception message to show.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
inline fun exceptionDialog(
    exception: Throwable,
    noinline dialogAction: (ExceptionDialog.() -> Unit)? = null,
): Optional<ButtonType> = exceptionDialog(null, null, exception, dialogAction)
