@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import javafx.concurrent.Worker
import javafx.scene.Node
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.ProgressDialog
import java.util.Optional

/**
 * Build a progress dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param worker progress worker.
 * @param dialogAction custom dialog action.
 * @return nothing.
 */
fun progressDialog(
    title: String? = null,
    graphic: Node? = null,
    worker: Worker<*>?,
    dialogAction: (ProgressDialog.() -> Unit)? = null,
): Optional<Void> =
    ProgressDialog(worker).also { dialog ->
        if (title != null) dialog.headerTitle = title
        when {
            graphic is ImageView -> dialog.graphicIcon = graphic
            graphic != null -> dialog.graphic = graphic
        }
        dialogAction?.invoke(dialog)
    }.showAndWait()

/**
 * Build a progress dialog with Kotlin DSL.
 *
 * @param worker progress worker.
 * @param dialogAction custom dialog action.
 * @return nothing.
 */
inline fun progressDialog(
    worker: Worker<*>?,
    noinline dialogAction: (ProgressDialog.() -> Unit)? = null,
): Optional<Void> = progressDialog(null, null, worker, dialogAction)
