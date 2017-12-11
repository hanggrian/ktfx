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
import javafx.util.Builder
import javafx.util.Callback

interface DialogBuilder<R> : Builder<Dialog<R>> {

    var owner: Window

    val resizableProperty: BooleanProperty
    var isResizable: Boolean
        get() = resizableProperty.get()
        set(value) = resizableProperty.set(value)

    val showingProperty: ReadOnlyBooleanProperty
    val isShowing: Boolean get() = showingProperty.get()

    val heightProperty: ReadOnlyDoubleProperty
    var height: Double

    val widthProperty: ReadOnlyDoubleProperty
    var width: Double

    fun size(h: Double, w: Double) {
        height = h
        width = w
    }

    val xProperty: ReadOnlyDoubleProperty
    var x: Double

    val yProperty: ReadOnlyDoubleProperty
    var y: Double

    fun position(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    val titleProperty: StringProperty
    var title: String
        get() = titleProperty.get()
        set(value) = titleProperty.set(value)

    val paneProperty: ObjectProperty<DialogPane>
    var pane: DialogPane
        get() = paneProperty.get()
        set(value) = paneProperty.set(value)

    var icon: Image?
        get() = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons[0] else null
        }
        set(value) = (pane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons.clear()
            icons.add(icon)
        }

    val graphicProperty: ObjectProperty<Node> get() = pane.graphicProperty()
    var graphic: Node
        get() = graphicProperty.get()
        set(value) = graphicProperty.set(value)

    val headerTextProperty: StringProperty get() = pane.headerTextProperty()
    var headerText: String
        get() = headerTextProperty.get()
        set(value) = headerTextProperty.set(value)

    val contentTextProperty: StringProperty get() = pane.contentTextProperty()
    var contentText: String
        get() = contentTextProperty.get()
        set(value) = contentTextProperty.set(value)

    val contentProperty: ObjectProperty<Node> get() = pane.contentProperty()
    var content: Node
        get() = contentProperty.get()
        set(value) = contentProperty.set(value)

    val expandableContentProperty: ObjectProperty<Node> get() = pane.expandableContentProperty()
    var expandableContent: Node
        get() = expandableContentProperty.get()
        set(value) = expandableContentProperty.set(value)

    val expandedProperty: BooleanProperty get() = pane.expandedProperty()
    var isExpanded: Boolean
        get() = expandedProperty.get()
        set(value) = expandedProperty.set(value)

    val buttons: ObservableList<ButtonType> get() = pane.buttonTypes

    fun button(button: ButtonType) = pane.buttonTypes.add(button)

    fun buttons(vararg buttons: ButtonType) = buttons.forEach { button(it) }

    fun ButtonType.asNode(): Node = pane.lookupButton(this)

    val resultProperty: ObjectProperty<R>
    var result: R
        get() = resultProperty.get()
        set(value) = resultProperty.set(value)

    val resultConverterProperty: ObjectProperty<Callback<ButtonType, R>>
    fun resultConverter(converter: (ButtonType) -> R) = resultConverterProperty.set(Callback(converter))

    val onShowingProperty: ObjectProperty<EventHandler<DialogEvent>>
    fun onShowing(onShowing: (DialogEvent) -> Unit) = onShowingProperty.set(EventHandler(onShowing))

    val onShownProperty: ObjectProperty<EventHandler<DialogEvent>>
    fun onShown(onShown: (DialogEvent) -> Unit) = onShownProperty.set(EventHandler(onShown))

    val onHidingProperty: ObjectProperty<EventHandler<DialogEvent>>
    fun onHiding(onHiding: (DialogEvent) -> Unit) = onHidingProperty.set(EventHandler(onHiding))

    val onHiddenProperty: ObjectProperty<EventHandler<DialogEvent>>
    fun onHidden(onHidden: (DialogEvent) -> Unit) = onHiddenProperty.set(EventHandler(onHidden))

    val onCloseRequestProperty: ObjectProperty<EventHandler<DialogEvent>>
    fun onCloseRequest(onCloseRequest: (DialogEvent) -> Unit) = onCloseRequestProperty.set(EventHandler(onCloseRequest))
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