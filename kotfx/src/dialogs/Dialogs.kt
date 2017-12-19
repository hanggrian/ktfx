@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.ButtonData.OTHER
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.Window

inline var Dialog<*>.header: Node
    get() = dialogPane.header
    set(value) = dialogPane.setHeader(value)

inline var Dialog<*>.content: Node
    get() = dialogPane.content
    set(value) = dialogPane.setContent(value)

inline var Dialog<*>.expandableContent: Node
    get() = dialogPane.expandableContent
    set(value) = dialogPane.setExpandableContent(value)

inline var Dialog<*>.isExpanded: Boolean
    get() = dialogPane.isExpanded
    set(value) = dialogPane.setExpanded(value)

inline var Dialog<*>.icon: Image?
    get() = (dialogPane.scene.window as Stage).icon
    set(value) {
        (dialogPane.scene.window as Stage).icon = value
    }

/** Add button to this dialog and return it as a node. */
inline fun Dialog<*>.addButton(buttonType: ButtonType): Node {
    dialogPane.buttonTypes.add(buttonType)
    return dialogPane.lookupButton(buttonType)
}

/** Add custom button to this dialog and return it as a node. */
inline fun Dialog<*>.addButton(text: String, buttonData: ButtonBar.ButtonData = OTHER): Node = addButton(ButtonType(text, buttonData))

/** Add multiple buttons to this dialog, returning the last added as a node. */
inline fun Dialog<*>.addButtons(vararg buttonTypes: ButtonType): Node {
    dialogPane.buttonTypes.addAll(*buttonTypes)
    return dialogPane.lookupButton(buttonTypes.last())
}

/** Clear buttons in this dialog. */
inline fun Dialog<*>.clearButtons() = dialogPane.buttonTypes.clear()

@JvmOverloads
inline fun <R> dialog(
        title: String,
        headerText: String? = null,
        graphic: Node? = null,
        noinline init: (Dialog<R>.() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    setTitle(title)
    headerText?.let { setHeaderText(it) }
    graphic?.let { setGraphic(it) }
    init?.invoke(this)
}

@JvmOverloads
inline fun <R> Window.dialog(
        title: String,
        headerText: String? = null,
        graphic: Node? = null,
        noinline init: (Dialog<R>.() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    initOwner(this@dialog)
    setTitle(title)
    headerText?.let { setHeaderText(it) }
    graphic?.let { setGraphic(it) }
    init?.invoke(this)
}