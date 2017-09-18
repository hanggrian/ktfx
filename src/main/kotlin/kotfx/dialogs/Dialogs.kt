@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.util.Callback

@PublishedApi
internal inline var Dialog<*>.icon: Image
    get() = throw UnsupportedOperationException()
    set(value) {
        (dialogPane.scene.window as Stage).icons.add(value)
    }

/** Creates a base dialog with icon, title and optional initialization block. */
@JvmOverloads
inline fun <R> dialog(
        icon: Image,
        title: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

/** Creates a base dialog with title and optional initialization block. */
@JvmOverloads
inline fun <R> dialog(
        title: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.title = title
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

/** Creates a base dialog with optional initialization block. */
@JvmOverloads
inline fun <R> dialog(
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

/** Creates a choice dialog with icon, title, default choice, choices, and optional initialization block. */
@JvmOverloads
inline fun <T> choiceDialog(
        icon: Image,
        title: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a choice dialog with title, default choice, choices, and optional initialization block. */
@JvmOverloads
inline fun <T> choiceDialog(
        title: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.title = title
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a choice dialog with default choice, choices, and optional initialization block. */
@JvmOverloads
inline fun <T> choiceDialog(
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    init?.let { dialog.dialogPane.it() }
    return dialog
}

/** Creates a text input dialog with icon, title, default value and optional initialization block. */
@JvmOverloads
inline fun inputDialog(
        icon: Image,
        title: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.icon = icon
    dialog.title = title
    init?.let { dialog.dialogPane.it(dialog.editor) }
    return dialog
}

/** Creates a text input dialog with title, default value and optional initialization block. */
@JvmOverloads
inline fun inputDialog(
        title: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.title = title
    init?.let { dialog.dialogPane.it(dialog.editor) }
    return dialog
}

/** Creates a text input dialog with default value and optional initialization block. */
@JvmOverloads
inline fun inputDialog(
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    init?.let { dialog.dialogPane.it(dialog.editor) }
    return dialog
}