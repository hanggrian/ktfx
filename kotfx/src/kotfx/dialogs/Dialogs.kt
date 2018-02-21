@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.dialogs

import javafx.beans.property.BooleanProperty
import javafx.beans.property.ObjectProperty
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar.ButtonData
import javafx.scene.control.ButtonBar.ButtonData.OTHER
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotfx.icon
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

/** Removes old icons and set a new one to this dialog. */
inline var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        (dialogPane.scene.window as Stage).icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Property representing the header area of this dialog. */
inline val Dialog<*>.headerProperty: ObjectProperty<Node> get() = dialogPane.headerProperty()

/** Header area of this dialog. */
inline var Dialog<*>.header: Node
    get() = dialogPane.header
    set(value) = dialogPane.setHeader(value)

/** Property representing the content area of this dialog. */
inline val Dialog<*>.contentProperty: ObjectProperty<Node> get() = dialogPane.contentProperty()

/** Content area of this dialog. */
inline var Dialog<*>.content: Node
    get() = dialogPane.content
    set(value) = dialogPane.setContent(value)

/** Property representing the expandable content area of this dialog. */
inline val Dialog<*>.expandableContentProperty: ObjectProperty<Node> get() = dialogPane.expandableContentProperty()

/** Expandable content area of this dialog. */
inline var Dialog<*>.expandableContent: Node
    get() = dialogPane.expandableContent
    set(value) = dialogPane.setExpandableContent(value)

/** Property representing whether or not this dialog is expandable. */
inline val Dialog<*>.expandedProperty: BooleanProperty get() = dialogPane.expandedProperty()

inline var Dialog<*>.isExpanded: Boolean
    get() = dialogPane.isExpanded
    set(value) = dialogPane.setExpanded(value)

inline val Dialog<*>.buttons: ObservableList<ButtonType>
    get() = dialogPane.buttonTypes

inline fun Dialog<*>.lookupButton(button: ButtonType): Node = dialogPane.lookupButton(button)

/** Add custom button to this dialog and return it as a node. */
inline fun Dialog<*>.addButton(
    text: String,
    data: ButtonData = OTHER,
    noinline init: (Node.() -> Unit)? = null
): Boolean = addButton(ButtonType(text, data), init)

/** Add button to this dialog and return it as a node. */
fun Dialog<*>.addButton(
    type: ButtonType,
    init: (Node.() -> Unit)? = null
): Boolean {
    val result = buttons.add(type)
    if (init != null) lookupButton(type).init()
    return result
}

/** Add multiple custom buttons to this dialog, returning them as list of nodes. */
inline fun Dialog<*>.addButtons(
    vararg buttons: Pair<String, ButtonData>,
    noinline init: (List<Node>.() -> Unit)? = null
): Boolean = addButtons(*buttons.map { ButtonType(it.first, it.second) }.toTypedArray(), init = init)

/** Add multiple buttons to this dialog, returning them as list of nodes. */
fun Dialog<*>.addButtons(
    vararg types: ButtonType,
    init: (List<Node>.() -> Unit)? = null
): Boolean {
    val result = buttons.addAll(*types)
    if (init != null) types.map { lookupButton(it) }.init()
    return result
}

fun <R> dialog(
    title: String? = null,
    graphic: Node? = null,
    init: (Dialog<R>.() -> Unit)? = null
): Dialog<R> = Dialog<R>().apply {
    if (title != null) setTitle(title)
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    if (title != null && graphic != null) headerText = title
    init?.invoke(this)
}