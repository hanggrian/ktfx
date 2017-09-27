@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.*
import javafx.util.Callback

@JvmOverloads
inline fun <R> dialog(
        title: String,
        graphic: Node,
        headerText: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

@JvmOverloads
inline fun <R> dialog(
        graphic: Node,
        headerText: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.graphic = graphic
    dialog.headerText = headerText
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

@JvmOverloads
inline fun <R> dialog(
        headerText: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    dialog.headerText = headerText
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

@JvmOverloads
inline fun <R> dialog(
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> {
    val dialog = Dialog<R>()
    init?.let { dialog.resultConverter = dialog.dialogPane.it() }
    return dialog
}

@JvmOverloads
inline fun <T> choiceDialog(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun <T> choiceDialog(
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.graphic = graphic
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun <T> choiceDialog(
        headerText: String,
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun <T> choiceDialog(
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun <T> choiceDialog(
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> {
    val dialog = ChoiceDialog<T>(defaultChoice, *choices)
    init?.invoke(dialog.dialogPane)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.title = title
    dialog.graphic = graphic
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.graphic = graphic
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.headerText = headerText
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    dialog.contentText = contentText
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog(defaultValue)
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}

@JvmOverloads
inline fun inputDialog(
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> {
    val dialog = TextInputDialog()
    init?.invoke(dialog.dialogPane, dialog.editor)
    return dialog
}