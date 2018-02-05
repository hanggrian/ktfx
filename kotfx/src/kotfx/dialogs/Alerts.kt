@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView

@JvmOverloads
inline fun alert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = alert(null, null, contentText, *buttonTypes, init = init)

@JvmOverloads
fun alert(
        title: String?,
        graphic: Node?,
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        init: (Alert.() -> Unit)? = null
): Alert = Alert(NONE, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}

@JvmOverloads
inline fun infoAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = infoAlert(null, null, contentText, *buttonTypes, init = init)

@JvmOverloads
fun infoAlert(
        title: String?,
        graphic: Node?,
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        init: (Alert.() -> Unit)? = null
): Alert = Alert(INFORMATION, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}

@JvmOverloads
inline fun warningAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = warningAlert(null, null, contentText, *buttonTypes, init = init)

@JvmOverloads
fun warningAlert(
        title: String?,
        graphic: Node?,
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        init: (Alert.() -> Unit)? = null
): Alert = Alert(WARNING, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = confirmAlert(null, null, contentText, *buttonTypes, init = init)

@JvmOverloads
fun confirmAlert(
        title: String?,
        graphic: Node?,
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        init: (Alert.() -> Unit)? = null
): Alert = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}

@JvmOverloads
inline fun errorAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = errorAlert(null, null, contentText, *buttonTypes, init = init)

@JvmOverloads
fun errorAlert(
        title: String?,
        graphic: Node?,
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        init: (Alert.() -> Unit)? = null
): Alert = Alert(ERROR, contentText, *buttonTypes).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}