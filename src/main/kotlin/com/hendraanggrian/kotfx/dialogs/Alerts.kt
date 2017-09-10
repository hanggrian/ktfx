@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog

/**
 * Show an alert with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun alert(
        init: Alert.() -> Unit,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE)
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show an alert with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.NONE, contentText, *buttonTypes)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show an information alert with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun infoAlert(
        init: Alert.() -> Unit,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION)
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show an information alert with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.INFORMATION, contentText, *buttonTypes)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a warning alert with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun warningAlert(
        init: Alert.() -> Unit,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING)
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a warning alert with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.WARNING, contentText, *buttonTypes)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a confirmation alert with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun confirmAlert(
        init: Alert.() -> Unit,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION)
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a confirmation alert with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.CONFIRMATION, contentText, *buttonTypes)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show an error alert with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun errorAlert(
        init: Alert.() -> Unit,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR)
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show an error alert with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 */
@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline action: ((ButtonType) -> Unit)? = null
): Dialog<ButtonType> {
    val dialog = Alert(Alert.AlertType.ERROR, contentText, *buttonTypes)
    dialog.showOrWait(action)
    return dialog
}