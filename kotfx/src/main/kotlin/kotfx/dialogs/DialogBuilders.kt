@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.beans.property.*
import javafx.collections.ObservableList
import javafx.event.ActionEvent.ACTION
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.control.ButtonBar.ButtonData.*
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.Window
import javafx.util.Callback
import kotfx.internal.Instanced

@PublishedApi
internal class FXDialogBuilder<R> : DialogBuilder<Dialog<R>, R> {

    override val instance: Dialog<R> = Dialog()
}

interface DialogBuilder<out T : Dialog<R>, R> : Instanced<T> {

    var owner: Window
        get() = instance.owner
        set(value) = instance.initOwner(value)

    val resizableProperty: BooleanProperty get() = instance.resizableProperty()
    var isResizable: Boolean
        get() = instance.isResizable
        set(value) = instance.setResizable(value)

    val showingProperty: ReadOnlyBooleanProperty get() = instance.showingProperty()
    val isShowing: Boolean get() = instance.isShowing

    val heightProperty: ReadOnlyDoubleProperty get() = instance.heightProperty()
    var height: Double
        get() = instance.height
        set(value) = instance.setHeight(value)

    val widthProperty: ReadOnlyDoubleProperty get() = instance.widthProperty()
    var width: Double
        get() = instance.width
        set(value) = instance.setWidth(value)

    fun size(h: Double, w: Double) {
        height = h
        width = w
    }

    val xProperty: ReadOnlyDoubleProperty get() = instance.xProperty()
    var x: Double
        get() = instance.x
        set(value) = instance.setX(value)

    val yProperty: ReadOnlyDoubleProperty get() = instance.yProperty()
    var y: Double
        get() = instance.y
        set(value) = instance.setY(value)

    fun position(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    val titleProperty: StringProperty get() = instance.titleProperty()
    var title: String
        get() = instance.title
        set(value) = instance.setTitle(value)

    val paneProperty: ObjectProperty<DialogPane> get() = instance.dialogPaneProperty()
    var pane: DialogPane
        get() = instance.dialogPane
        set(value) = instance.setDialogPane(value)

    var icon: Image?
        get() = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons[0] else null
        }
        set(value) = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons.clear()
            icons.add(icon)
        }

    val graphicProperty: ObjectProperty<Node> get() = instance.graphicProperty()
    var graphic: Node
        get() = instance.graphic
        set(value) = instance.setGraphic(value)

    val headerTextProperty: StringProperty get() = instance.headerTextProperty()
    var headerText: String
        get() = instance.headerText
        set(value) = instance.setHeaderText(value)

    val contentTextProperty: StringProperty get() = instance.contentTextProperty()
    var contentText: String
        get() = instance.contentText
        set(value) = instance.setContentText(value)

    val contentProperty: ObjectProperty<Node> get() = pane.contentProperty()
    var content: Node
        get() = pane.content
        set(value) = pane.setContent(value)

    val expandableContentProperty: ObjectProperty<Node> get() = pane.expandableContentProperty()
    var expandableContent: Node
        get() = pane.expandableContent
        set(value) = pane.setExpandableContent(value)

    val expandedProperty: BooleanProperty get() = pane.expandedProperty()
    var isExpanded: Boolean
        get() = pane.isExpanded
        set(value) = pane.setExpanded(value)

    val buttons: ObservableList<ButtonType> get() = pane.buttonTypes

    fun button(button: ButtonType) = pane.buttonTypes.add(button)

    fun buttons(vararg buttons: ButtonType) = buttons.forEach { button(it) }

    fun ButtonType.asNode(): Node = pane.lookupButton(this)

    val resultProperty: ObjectProperty<R> get() = instance.resultProperty()
    var result: R
        get() = instance.result
        set(value) = instance.setResult(value)

    val resultConverterProperty: ObjectProperty<Callback<ButtonType, R>> get() = instance.resultConverterProperty()
    fun resultConverter(converter: (ButtonType) -> R) = instance.setResultConverter(converter)

    val onShowingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = instance.onShowingProperty()
    fun onShowing(onShowing: (DialogEvent) -> Unit) = instance.setOnShowing(onShowing)

    val onShownProperty: ObjectProperty<EventHandler<DialogEvent>> get() = instance.onShownProperty()
    fun onShown(onShown: (DialogEvent) -> Unit) = instance.setOnShown(onShown)

    val onHidingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = instance.onHidingProperty()
    fun onHiding(onHiding: (DialogEvent) -> Unit) = instance.setOnHiding(onHiding)

    val onHiddenProperty: ObjectProperty<EventHandler<DialogEvent>> get() = instance.onHiddenProperty()
    fun onHidden(onHidden: (DialogEvent) -> Unit) = instance.setOnHidden(onHidden)

    val onCloseRequestProperty: ObjectProperty<EventHandler<DialogEvent>> get() = instance.onCloseRequestProperty()
    fun onCloseRequest(onCloseRequest: (DialogEvent) -> Unit) = instance.setOnCloseRequest(onCloseRequest)
}

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)

@JvmOverloads
inline fun <T : Dialog<R>, R> DialogBuilder<T, R>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun DialogBuilder<*, *>.buttonTypeOf(
        text: String,
        data: ButtonBar.ButtonData,
        noinline action: (() -> Unit)?
): ButtonType = ButtonType(text, data).apply {
    button(this)
    if (action != null) asNode().addEventFilter(ACTION) { event ->
        event.consume()
        action()
    }
}