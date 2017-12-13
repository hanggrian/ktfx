@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.event.ActionEvent
import javafx.scene.Node
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.ButtonData.*
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.image.Image
import javafx.stage.Stage

interface Dialogged<out T> {
    val dialog: T
}

interface Dialoggable<out T : Dialog<R>, R> : Dialogged<T> {

    fun contentText(text: String) = dialog.setContentText(text)
    fun headerText(text: String) = dialog.setHeaderText(text)

    fun graphic(graphic: Node) = dialog.setGraphic(graphic)

    fun resizable(resizable: Boolean) = dialog.setResizable(resizable)

    fun width(width: Number) = dialog.setWidth(width.toDouble())
    fun height(height: Number) = dialog.setHeight(height.toDouble())

    fun title(title: String) = dialog.setTitle(title)

    fun x(x: Number) = dialog.setX(x.toDouble())
    fun y(y: Number) = dialog.setY(y.toDouble())

    fun onShowing(action: (DialogEvent) -> Unit) = dialog.setOnShowing(action)
    fun onShown(action: (DialogEvent) -> Unit) = dialog.setOnShown(action)
    fun onHiding(action: (DialogEvent) -> Unit) = dialog.setOnHiding(action)
    fun onHidden(action: (DialogEvent) -> Unit) = dialog.setOnHidden(action)
    fun onCloseRequest(action: (DialogEvent) -> Unit) = dialog.setOnCloseRequest(action)

    fun header(header: Node) = dialog.dialogPane.setHeader(header)
    fun content(content: Node) = dialog.dialogPane.setContent(content)

    fun expandableContent(content: Node) = dialog.dialogPane.setExpandableContent(content)
    fun expand(expand: Boolean) = dialog.dialogPane.setExpanded(expand)

    fun button(button: ButtonType) = dialog.dialogPane.buttonTypes.add(button)
    fun buttons(vararg buttons: ButtonType) = buttons.forEach { button(it) }
    fun ButtonType.asNode(): Node = dialog.dialogPane.lookupButton(this)

    fun icon(icon: Image) = (dialog.dialogPane.scene.window as Stage).icons.let { icons ->
        if (!icons.isEmpty()) icons.clear()
        icons.add(icon)
    }
}

@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> Dialoggable<T, R>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun Dialoggable<*, *>.buttonTypeOf(
        text: String,
        data: ButtonBar.ButtonData,
        noinline action: (() -> Unit)?
): ButtonType = ButtonType(text, data).apply {
    button(this)
    if (action != null) asNode().addEventFilter(ActionEvent.ACTION) { event ->
        event.consume()
        action()
    }
}