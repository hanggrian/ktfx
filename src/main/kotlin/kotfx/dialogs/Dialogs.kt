@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.control.ChoiceDialog
import javafx.scene.control.Dialog
import javafx.scene.control.TextInputDialog

/** Show a dialog and wait if [action] is supplied, will only emit result if it is present and not null. */
@PublishedApi
internal inline fun <T> Dialog<T>.showOrWait(
        noinline action: ((T) -> Unit)? = null
): Unit = when (action) {
    null -> show()
    else -> showAndWait().ifPresent { it?.let(action) }
}

/**
 * Show a base dialog with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun <R> dialog(
        init: Dialog<R>.() -> Unit,
        noinline action: ((R) -> Unit)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a choice dialog with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun <T> choiceDialog(
        init: ChoiceDialog<T>.() -> Unit,
        noinline action: ((T) -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>()
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a choice dialog with specified choices and default choice.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun <T> choiceDialog(
        defaultChoice: T,
        vararg choices: T,
        noinline action: ((T) -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a choice dialog with specified choices and default choice.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun <T> choiceDialog(
        defaultChoice: T,
        choices: Collection<T>,
        noinline action: ((T) -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, choices)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a text input dialog with specified title and buttons.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun inputDialog(
        defaultValue: String,
        noinline action: ((String) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.showOrWait(action)
    return dialog
}

/**
 * Show a text input dialog with custom initialization block.
 * If [action] is supplied, dialog shown will wait for input and execute [action] block if result is present.
 * [action] will only execute if result is present and not null.
 */
@JvmOverloads
inline fun inputDialog(
        init: TextInputDialog.() -> Unit,
        noinline action: ((String) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog()
    dialog.init()
    dialog.showOrWait(action)
    return dialog
}