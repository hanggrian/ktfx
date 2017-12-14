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

interface _DialogBase<out D : Dialog<*>> {
    val dialog: D

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

@JvmOverloads inline fun _DialogBase<*>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)
@JvmOverloads inline fun _DialogBase<*>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)
@JvmOverloads inline fun _DialogBase<*>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)
@JvmOverloads inline fun _DialogBase<*>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)
@JvmOverloads inline fun _DialogBase<*>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)
@JvmOverloads inline fun _DialogBase<*>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)
@JvmOverloads inline fun _DialogBase<*>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)
@JvmOverloads inline fun _DialogBase<*>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)
@JvmOverloads inline fun _DialogBase<*>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)
@JvmOverloads inline fun _DialogBase<*>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)
@JvmOverloads inline fun _DialogBase<*>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)
@JvmOverloads inline fun _DialogBase<*>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)
@JvmOverloads inline fun _DialogBase<*>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)
@JvmOverloads inline fun _DialogBase<*>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)
@JvmOverloads inline fun _DialogBase<*>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun _DialogBase<*>.buttonTypeOf(
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

class _Dialog<R> : Dialog<R>(), _DialogBase<Dialog<R>> {
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