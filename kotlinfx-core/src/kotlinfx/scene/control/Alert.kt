@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.scene.control

import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.CONFIRMATION
import javafx.scene.control.Alert.AlertType.ERROR
import javafx.scene.control.Alert.AlertType.INFORMATION
import javafx.scene.control.Alert.AlertType.NONE
import javafx.scene.control.Alert.AlertType.WARNING
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView

inline fun alert(
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = alert(null, null, contentText, *buttonTypes, init = init)

fun alert(
    title: String?,
    graphic: Node?,
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(NONE, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}

inline fun infoAlert(
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = infoAlert(null, null, contentText, *buttonTypes, init = init)

fun infoAlert(
    title: String?,
    graphic: Node?,
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(INFORMATION, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}

inline fun warningAlert(
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = warningAlert(null, null, contentText, *buttonTypes, init = init)

fun warningAlert(
    title: String?,
    graphic: Node?,
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(WARNING, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}

inline fun confirmAlert(
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = confirmAlert(null, null, contentText, *buttonTypes, init = init)

fun confirmAlert(
    title: String?,
    graphic: Node?,
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}

inline fun errorAlert(
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    noinline init: (Alert.() -> Unit)? = null
): Alert = errorAlert(null, null, contentText, *buttonTypes, init = init)

fun errorAlert(
    title: String?,
    graphic: Node?,
    contentText: String = "",
    vararg buttonTypes: ButtonType,
    init: (Alert.() -> Unit)? = null
): Alert = Alert(ERROR, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { graphicIcon = it } ?: setGraphic(graphic)
    init?.invoke(this)
}