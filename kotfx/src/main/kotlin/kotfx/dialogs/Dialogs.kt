@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.event.ActionEvent.ACTION
import javafx.scene.Node
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.ButtonData.*
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.Window
import kotfx.internal.DialogDsl

interface Dialogged<out D> {
    val dialog: D
}

interface Dialoggable<out D : Dialog<*>> : Dialogged<D> {

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

@JvmOverloads inline fun Dialoggable<*>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)
@JvmOverloads inline fun Dialoggable<*>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)
@JvmOverloads inline fun Dialoggable<*>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)
@JvmOverloads inline fun Dialoggable<*>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)
@JvmOverloads inline fun Dialoggable<*>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)
@JvmOverloads inline fun Dialoggable<*>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)
@JvmOverloads inline fun Dialoggable<*>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)
@JvmOverloads inline fun Dialoggable<*>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)
@JvmOverloads inline fun Dialoggable<*>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)
@JvmOverloads inline fun Dialoggable<*>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)
@JvmOverloads inline fun Dialoggable<*>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)
@JvmOverloads inline fun Dialoggable<*>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)
@JvmOverloads inline fun Dialoggable<*>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)
@JvmOverloads inline fun Dialoggable<*>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)
@JvmOverloads inline fun Dialoggable<*>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun Dialoggable<*>.buttonTypeOf(
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

class _Dialog<R> : Dialog<R>(), Dialoggable<Dialog<R>> {
    override val dialog: Dialog<R> get() = this
}

@JvmOverloads
inline fun <R> dialog(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = _Dialog<R>().apply {
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}

@JvmOverloads
inline fun <R> Window.dialog(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = _Dialog<R>().apply {
    initOwner(this@dialog)
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}