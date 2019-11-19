@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView

/**
 * Show an alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
fun alert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = Alert(AlertType.NONE, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()

/**
 * Show an alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
inline fun alert(
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = alert(null, null, content, *buttonTypes)

/**
 * Show an information alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
fun infoAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = Alert(AlertType.INFORMATION, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()

/**
 * Show an information alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
inline fun infoAlert(
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = infoAlert(null, null, content, *buttonTypes)

/**
 * Show a warning alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
fun warningAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = Alert(AlertType.WARNING, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()

/**
 * Show a warning alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
inline fun warningAlert(
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = warningAlert(null, null, content, *buttonTypes)

/**
 * Show a confirmation alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
fun confirmAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = Alert(AlertType.CONFIRMATION, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()

/**
 * Show a confirmation alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
inline fun confirmAlert(
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = confirmAlert(null, null, content, *buttonTypes)

/**
 * Show an error alert with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
fun errorAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = Alert(AlertType.ERROR, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
}.showAndWait()

/**
 * Show an error alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @return selected alert button.
 */
inline fun errorAlert(
    content: String = "",
    vararg buttonTypes: ButtonType
): Optional<ButtonType> = errorAlert(null, null, content, *buttonTypes)
