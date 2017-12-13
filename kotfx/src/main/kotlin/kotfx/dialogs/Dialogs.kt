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
import javafx.scene.image.Image
import javafx.stage.Stage
import kotfx.internal.DialogDsl

interface Dialogged<out D : Dialog<*>> {
    val dialog: D
}

interface Dialoggable<out D : Dialog<*>> : Dialogged<D> {
    fun header(value: String) = dialog.setHeaderText(value)
    fun content(value: String) = dialog.setContentText(value)

    fun graphic(value: Node) = dialog.setGraphic(value)

    fun resizable(value: Boolean) = dialog.setResizable(value)

    fun width(value: Number) = dialog.setWidth(value.toDouble())
    fun height(value: Number) = dialog.setHeight(value.toDouble())

    fun title(value: String) = dialog.setTitle(value)

    fun x(value: Number) = dialog.setX(value.toDouble())
    fun y(value: Number) = dialog.setY(value.toDouble())

    fun header(value: Node) = dialog.dialogPane.setHeader(value)
    fun content(value: Node) = dialog.dialogPane.setContent(value)

    fun expandableContent(value: Node) = dialog.dialogPane.setExpandableContent(value)
    fun expand(value: Boolean) = dialog.dialogPane.setExpanded(value)

    fun button(value: ButtonType) = dialog.dialogPane.buttonTypes.add(value)
    fun buttons(vararg values: ButtonType) = values.forEach { button(it) }
    fun ButtonType.asNode(): Node = dialog.dialogPane.lookupButton(this)

    fun icon(value: Image) = (dialog.dialogPane.scene.window as Stage).icons.let { icons ->
        if (!icons.isEmpty()) icons.clear()
        icons.add(value)
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
inline fun <R> dialogOf(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = _Dialog<R>().apply {
    title(title)
    if (icon != null) icon(icon)
    if (init != null) init()
}

@JvmOverloads
inline fun <R> dialog(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = dialogOf(title, icon, init).apply { show() }

@JvmOverloads
inline fun <R> dialogWait(
        title: String,
        icon: Image? = null,
        noinline init: ((@DialogDsl _Dialog<R>).() -> Unit)? = null
): Dialog<R> = dialogOf(title, icon, init).apply { showAndWait() }