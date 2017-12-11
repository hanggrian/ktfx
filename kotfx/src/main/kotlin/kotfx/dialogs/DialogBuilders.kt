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
internal open class FXDialogBuilder<R> : DialogBuilder<R> {

    override val t: Dialog<R> = Dialog()
}

interface DialogBuilder<R> : Instanced<Dialog<R>> {

    var owner: Window
        get() = t.owner
        set(value) = t.initOwner(value)

    val resizableProperty: BooleanProperty get() = t.resizableProperty()
    var isResizable: Boolean
        get() = t.isResizable
        set(value) = t.setResizable(value)

    val showingProperty: ReadOnlyBooleanProperty get() = t.showingProperty()
    val isShowing: Boolean get() = t.isShowing

    val heightProperty: ReadOnlyDoubleProperty get() = t.heightProperty()
    var height: Double
        get() = t.height
        set(value) = t.setHeight(value)

    val widthProperty: ReadOnlyDoubleProperty get() = t.widthProperty()
    var width: Double
        get() = t.width
        set(value) = t.setWidth(value)

    fun size(h: Double, w: Double) {
        height = h
        width = w
    }

    val xProperty: ReadOnlyDoubleProperty get() = t.xProperty()
    var x: Double
        get() = t.x
        set(value) = t.setX(value)

    val yProperty: ReadOnlyDoubleProperty get() = t.yProperty()
    var y: Double
        get() = t.y
        set(value) = t.setY(value)

    fun position(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    val titleProperty: StringProperty get() = t.titleProperty()
    var title: String
        get() = t.title
        set(value) = t.setTitle(value)

    val paneProperty: ObjectProperty<DialogPane> get() = t.dialogPaneProperty()
    var pane: DialogPane
        get() = t.dialogPane
        set(value) = t.setDialogPane(value)

    var icon: Image?
        get() = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons[0] else null
        }
        set(value) = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons.clear()
            icons.add(icon)
        }

    val graphicProperty: ObjectProperty<Node> get() = t.graphicProperty()
    var graphic: Node
        get() = t.graphic
        set(value) = t.setGraphic(value)

    val headerTextProperty: StringProperty get() = t.headerTextProperty()
    var headerText: String
        get() = t.headerText
        set(value) = t.setHeaderText(value)

    val contentTextProperty: StringProperty get() = t.contentTextProperty()
    var contentText: String
        get() = t.contentText
        set(value) = t.setContentText(value)

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

    val resultProperty: ObjectProperty<R> get() = t.resultProperty()
    var result: R
        get() = t.result
        set(value) = t.setResult(value)

    val resultConverterProperty: ObjectProperty<Callback<ButtonType, R>> get() = t.resultConverterProperty()
    fun resultConverter(converter: (ButtonType) -> R) = t.setResultConverter(converter)

    val onShowingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = t.onShowingProperty()
    fun onShowing(onShowing: (DialogEvent) -> Unit) = t.setOnShowing(onShowing)

    val onShownProperty: ObjectProperty<EventHandler<DialogEvent>> get() = t.onShownProperty()
    fun onShown(onShown: (DialogEvent) -> Unit) = t.setOnShown(onShown)

    val onHidingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = t.onHidingProperty()
    fun onHiding(onHiding: (DialogEvent) -> Unit) = t.setOnHiding(onHiding)

    val onHiddenProperty: ObjectProperty<EventHandler<DialogEvent>> get() = t.onHiddenProperty()
    fun onHidden(onHidden: (DialogEvent) -> Unit) = t.setOnHidden(onHidden)

    val onCloseRequestProperty: ObjectProperty<EventHandler<DialogEvent>> get() = t.onCloseRequestProperty()
    fun onCloseRequest(onCloseRequest: (DialogEvent) -> Unit) = t.setOnCloseRequest(onCloseRequest)
}

@JvmOverloads
inline fun <R> DialogBuilder<R>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)

@JvmOverloads
inline fun <R> DialogBuilder<R>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun DialogBuilder<*>.buttonTypeOf(
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