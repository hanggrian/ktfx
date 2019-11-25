package ktfx.jfoenix.dialogs

import com.jfoenix.controls.JFXAlert
import java.util.Optional
import javafx.scene.Node
import javafx.scene.image.ImageView
import javafx.stage.Stage
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle

/**
 * Show an alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 */
fun <R> Stage.jfxAlert(
    title: String? = null,
    graphic: Node? = null
): Optional<R> = JFXAlert<R>(this).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()
