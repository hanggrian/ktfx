@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

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
): Dialog<R> = Dialog<R>().apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    init?.let { resultConverter = dialogPane.it() }
}

@JvmOverloads
inline fun <R> dialog(
        graphic: Node,
        headerText: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> = Dialog<R>().apply {
    this.graphic = graphic
    this.headerText = headerText
    init?.let { resultConverter = dialogPane.it() }
}

@JvmOverloads
inline fun <R> dialog(
        headerText: String,
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> = Dialog<R>().apply {
    this.headerText = headerText
    init?.let { resultConverter = dialogPane.it() }
}

@JvmOverloads
inline fun <R> dialog(
        noinline init: (DialogPane.() -> Callback<ButtonType, R>)? = null
): Dialog<R> = Dialog<R>().apply {
    init?.let { resultConverter = dialogPane.it() }
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
): Dialog<T> = ChoiceDialog<T>(defaultChoice, *choices).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun <T> choiceDialog(
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> = ChoiceDialog<T>(defaultChoice, *choices).apply {
    this.graphic = graphic
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun <T> choiceDialog(
        headerText: String,
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> = ChoiceDialog<T>(defaultChoice, *choices).apply {
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun <T> choiceDialog(
        contentText: String,
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> = ChoiceDialog<T>(defaultChoice, *choices).apply {
    this.contentText = contentText
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun <T> choiceDialog(
        defaultChoice: T,
        vararg choices: T,
        noinline init: (DialogPane.() -> Unit)? = null
): Dialog<T> = ChoiceDialog<T>(defaultChoice, *choices).apply {
    init?.invoke(dialogPane)
}

@JvmOverloads
inline fun inputDialog(
        title: String,
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog(defaultValue).apply {
    this.title = title
    this.graphic = graphic
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane, editor)
}

@JvmOverloads
inline fun inputDialog(
        graphic: Node,
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog(defaultValue).apply {
    this.graphic = graphic
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane, editor)
}

@JvmOverloads
inline fun inputDialog(
        headerText: String,
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog(defaultValue).apply {
    this.headerText = headerText
    this.contentText = contentText
    init?.invoke(dialogPane, editor)
}

@JvmOverloads
inline fun inputDialog(
        contentText: String,
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog(defaultValue).apply {
    this.contentText = contentText
    init?.invoke(dialogPane, editor)
}

@JvmOverloads
inline fun inputDialog(
        defaultValue: String,
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog(defaultValue).apply {
    init?.invoke(dialogPane, editor)
}

@JvmOverloads
inline fun inputDialog(
        noinline init: (DialogPane.(TextField) -> Unit)? = null
): Dialog<String> = TextInputDialog().apply {
    init?.invoke(dialogPane, editor)
}