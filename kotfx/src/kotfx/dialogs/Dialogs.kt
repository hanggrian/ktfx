@file:Suppress("NOTHING_TO_INLINE")

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
import kotfx.internal.KotFXInternals.NO_GETTER
import kotfx.internal.KotFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

//region direct access to dialogPane properties
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

inline val Dialog<*>.expandedProperty: BooleanProperty
    get() = dialogPane.expandedProperty()

inline var Dialog<*>.isExpanded: Boolean
    get() = expandedProperty.get()
    set(value) = expandedProperty.set(value)

inline val Dialog<*>.buttons: ObservableList<ButtonType>
    get() = dialogPane.buttonTypes

inline fun Dialog<*>.lookupButton(button: ButtonType): Node = dialogPane.lookupButton(button) as Node
//endregion

/** Apply [imageView] as graphic and icon of this dialog. */
var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply [header] as header text and title of this dialog. */
var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Add custom button to this dialog and return it as a node. */
inline fun Dialog<*>.button(text: String, data: ButtonData = OTHER): Node = button(ButtonType(text, data))

/** Add button to this dialog and return it as a node. */
fun Dialog<*>.button(button: ButtonType): Node {
    buttons.add(button)
    return lookupButton(button)
}

/** Add multiple buttons to this dialog, returning them as list of nodes. */
fun Dialog<*>.buttons(vararg buttons: ButtonType): List<Node> {
    this.buttons.addAll(*buttons)
    return buttons.map { button -> lookupButton(button) }
}