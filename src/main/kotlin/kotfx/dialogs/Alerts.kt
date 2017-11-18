@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
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
): Dialog<ButtonType> = Alert(NONE, contentText, *buttonTypes).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun alert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(NONE, contentText, *buttonTypes).apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun alert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(NONE, contentText, *buttonTypes).apply {
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(NONE, contentText, *buttonTypes).apply {
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun infoAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(INFORMATION, contentText, *buttonTypes).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun infoAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(INFORMATION, contentText, *buttonTypes).apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun infoAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(INFORMATION, contentText, *buttonTypes).apply {
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(INFORMATION, contentText, *buttonTypes).apply {
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun warningAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(WARNING, contentText, *buttonTypes).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun warningAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(WARNING, contentText, *buttonTypes).apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun warningAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(WARNING, contentText, *buttonTypes).apply {
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(WARNING, contentText, *buttonTypes).apply {
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun confirmAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun confirmAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun confirmAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun errorAlert(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(ERROR, contentText, *buttonTypes).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun errorAlert(
        graphic: Node,
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(ERROR, contentText, *buttonTypes).apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun errorAlert(
        headerText: String,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(ERROR, contentText, *buttonTypes).apply {
    this.headerText = headerText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<ButtonType> = Alert(ERROR, contentText, *buttonTypes).apply {
    init?.invoke(dialogPane)
}