@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.dialogs

import com.jfoenix.controls.JFXAlert
import javafx.scene.Node
import javafx.scene.image.ImageView
import javafx.stage.Stage
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import java.util.Optional

/**
 * Show a JFoenix alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param dialogAction custom dialog action.
 * @return dialog result.
 */
fun <T> Stage.jfxAlert(
    title: String? = null,
    graphic: Node? = null,
    dialogAction: (JFXAlert<T>.() -> Unit)? = null,
): Optional<T> =
    JFXAlert<T>(this)
        .also { dialog ->
            if (title != null) dialog.headerTitle = title
            when {
                graphic is ImageView -> dialog.graphicIcon = graphic
                graphic != null -> dialog.graphic = graphic
            }
            dialogAction?.invoke(dialog)
        }.showAndWait()

/**
 * Show an JFoenix alert.
 *
 * @param dialogAction custom dialog action.
 * @return dialog result.
 */
inline fun <T> Stage.jfxAlert(
    noinline dialogAction: (JFXAlert<T>.() -> Unit)? = null,
): Optional<T> = jfxAlert(null, null, dialogAction)
