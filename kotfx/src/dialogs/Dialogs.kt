@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.property.ObjectProperty
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar.ButtonData
import javafx.scene.control.ButtonBar.ButtonData.OTHER
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Stage

inline var Dialog<*>.icon: Image?
    get() = (dialogPane.scene.window as Stage).icon
    set(value) {
        (dialogPane.scene.window as Stage).icon = value
    }

inline var Dialog<*>.header: Node
    get() = dialogPane.header
    set(value) = dialogPane.setHeader(value)

inline var Dialog<*>.content: Node
    get() = dialogPane.content
    set(value) = dialogPane.setContent(value)

inline val Dialog<*>.expandableContentProperty: ObjectProperty<Node>
    get() = dialogPane.expandableContentProperty()

inline var Dialog<*>.expandableContent: Node
    get() = expandableContentProperty.get()
    set(value) = expandableContentProperty.set(value)

inline val Dialog<*>.expandedProperty
    get() = dialogPane.expandedProperty()

inline var Dialog<*>.isExpanded: Boolean
    get() = expandedProperty.get()
    set(value) = expandedProperty.set(value)

inline val Dialog<*>.buttons: ObservableList<ButtonType>
    get() = dialogPane.buttonTypes

inline fun Dialog<*>.lookupButton(button: ButtonType): Node = dialogPane.lookupButton(button) as Node

/** Add button to this dialog and return it as a node. */
inline fun Dialog<*>.button(button: ButtonType): Node {
    buttons.add(button)
    return lookupButton(button)
}

/** Add custom button to this dialog and return it as a node. */
inline fun Dialog<*>.button(text: String, data: ButtonData = OTHER): Node = button(ButtonType(text, data))

/** Add multiple buttons to this dialog, returning them as list of nodes. */
inline fun Dialog<*>.buttons(vararg buttons: ButtonType): List<Node> {
    this.buttons.addAll(*buttons)
    return buttons.map { button -> lookupButton(button) }
}

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