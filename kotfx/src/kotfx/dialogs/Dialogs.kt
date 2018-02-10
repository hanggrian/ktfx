@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.dialogs

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
import kotfx.properties.MutableAnyProperty
import kotfx.properties.MutableBooleanProperty
import kotlin.DeprecationLevel.ERROR

//region direct access to dialogPane's properties and more
inline var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        listOf(1)
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

inline var Dialog<*>.header: Node
    get() = dialogPane.header
    set(value) = dialogPane.setHeader(value)

inline var Dialog<*>.content: Node
    get() = dialogPane.content
    set(value) = dialogPane.setContent(value)

inline val Dialog<*>.expandableContentProperty: MutableAnyProperty<Node> get() = dialogPane.expandableContentProperty()
inline var Dialog<*>.expandableContent: Node
    get() = expandableContentProperty.get()
    set(value) = expandableContentProperty.set(value)

inline val Dialog<*>.expandedProperty: MutableBooleanProperty get() = dialogPane.expandedProperty()
inline var Dialog<*>.isExpanded: Boolean
    get() = expandedProperty.get()
    set(value) = expandedProperty.set(value)

inline val Dialog<*>.buttons: ObservableList<ButtonType>
    get() = dialogPane.buttonTypes

inline fun Dialog<*>.lookupButton(button: ButtonType): Node = dialogPane.lookupButton(button) as Node

/** Add custom button to this dialog and return it as a node. */
inline fun Dialog<*>.addButton(text: String, data: ButtonData = OTHER): Node = addButton(ButtonType(text, data))

/** Add button to this dialog and return it as a node. */
fun Dialog<*>.addButton(button: ButtonType): Node {
    buttons.add(button)
    return lookupButton(button)
}

/** Add multiple custom buttons to this dialog, returning them as list of nodes. */
inline fun Dialog<*>.addButtons(vararg buttons: Pair<String, ButtonData>): List<Node> = addButtons(*buttons.map { ButtonType(it.first, it.second) }.toTypedArray())

/** Add multiple buttons to this dialog, returning them as list of nodes. */
fun Dialog<*>.addButtons(vararg buttons: ButtonType): List<Node> {
    this.buttons.addAll(*buttons)
    return buttons.map { button -> lookupButton(button) }
}
//endregion

@JvmOverloads
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