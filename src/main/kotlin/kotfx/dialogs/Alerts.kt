@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogPane

@JvmOverloads
inline fun alert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun alert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun alert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun infoAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun infoAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun infoAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun warningAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun warningAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun warningAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun confirmAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun confirmAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun confirmAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun errorAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun errorAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun errorAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.headerText = headerText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    init?.invoke(dialog.dialogPane)
    return dialog
}