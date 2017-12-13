@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.event.ActionEvent
import javafx.scene.Node
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.ButtonData.*
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.stage.Stage
import kotfx.internal.Instanced

interface _Dialogable<out T : Dialog<R>, R> : Instanced<T> {

    fun title(title: String) = instance.setTitle(title)

    fun expand(expand: Boolean) = instance.dialogPane.setExpanded(expand)
    fun expandableContent(content: Node) = instance.dialogPane.setExpandableContent(content)

    var icon: Image?
        get() = (instance.dialogPane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons[0] else null
        }
        set(value) = (instance.dialogPane.scene.window as Stage).icons.let { icons ->
            if (!icons.isEmpty()) icons.clear()
            icons.add(icon)
        }

    fun button(button: ButtonType) = instance.dialogPane.buttonTypes.add(button)

    fun buttons(vararg buttons: ButtonType) = buttons.forEach { button(it) }

    fun ButtonType.asNode(): Node = instance.dialogPane.lookupButton(this)
}

@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.leftButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, LEFT, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.rightButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, RIGHT, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.helpButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.help2Button(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, HELP_2, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.yesButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, YES, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.noButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NO, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.nextButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, NEXT_FORWARD, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.backButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BACK_PREVIOUS, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.finishButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, FINISH, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.applyButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, APPLY, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.cancelButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, CANCEL_CLOSE, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.okButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OK_DONE, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.bigButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, BIG_GAP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.smallButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, SMALL_GAP, action)
@JvmOverloads inline fun <T : Dialog<R>, R> _Dialogable<T, R>.otherButton(text: String, noinline action: (() -> Unit)? = null): ButtonType = buttonTypeOf(text, OTHER, action)

@PublishedApi
internal inline fun _Dialogable<*, *>.buttonTypeOf(
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