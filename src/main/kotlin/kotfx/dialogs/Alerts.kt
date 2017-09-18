@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogPane
import javafx.scene.image.Image

/** Creates an alert with icon, title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun alert(
        icon: Image,
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an alert with title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun alert(
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an alert with content, buttons, and optional initialization block. */
@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an information alert with icon, title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun infoAlert(
        icon: Image,
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an information alert with title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun infoAlert(
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an information alert with content, buttons, and optional initialization block. */
@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a warning alert with icon, title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun warningAlert(
        icon: Image,
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a warning alert with title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun warningAlert(
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a warning alert with content, buttons, and optional initialization block. */
@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a confirmation alert with icon, title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun confirmAlert(
        icon: Image,
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a confirmation alert with title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun confirmAlert(
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a confirmation alert with content, buttons, and optional initialization block. */
@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an error alert with icon, title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun errorAlert(
        icon: Image,
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an error alert with title, content, buttons, and optional initialization block. */
@JvmOverloads
inline fun errorAlert(
        title: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates an error alert with content, buttons, and optional initialization block. */
@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    init?.let { dialog.dialogPane.it() }
    return dialog
}