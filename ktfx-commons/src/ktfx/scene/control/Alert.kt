@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.control

import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView

/**
 * Build an alert with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
fun alert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(AlertType.NONE, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build an alert with Kotlin DSL.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
inline fun alert(
    content: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = alert(null, null, content, *buttonTypes, init = init)

/**
 * Build an information alert with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
fun infoAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(AlertType.INFORMATION, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build an information alert with Kotlin DSL.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
inline fun infoAlert(
    content: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = infoAlert(null, null, content, *buttonTypes, init = init)

/**
 * Build a warning alert with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
fun warningAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(AlertType.WARNING, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build a warning alert with Kotlin DSL.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
inline fun warningAlert(
    content: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = warningAlert(null, null, content, *buttonTypes, init = init)

/**
 * Build a confirmation alert with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
fun confirmAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(AlertType.CONFIRMATION, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build a confirmation alert with Kotlin DSL.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
inline fun confirmAlert(
    content: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = confirmAlert(null, null, content, *buttonTypes, init = init)

/**
 * Build an error alert with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
fun errorAlert(
    title: String? = null,
    graphic: Node? = null,
    content: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(AlertType.ERROR, content, *buttonTypes).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build an error alert with Kotlin DSL.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param init custom initialization block.
 */
inline fun errorAlert(
    content: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = errorAlert(null, null, content, *buttonTypes, init = init)