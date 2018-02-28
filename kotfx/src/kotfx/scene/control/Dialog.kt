@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.scene.Node
import javafx.scene.control.ButtonBar.ButtonData
import javafx.scene.control.ButtonBar.ButtonData.OTHER
import javafx.scene.control.ButtonType
import javafx.scene.control.ButtonType.APPLY
import javafx.scene.control.ButtonType.CANCEL
import javafx.scene.control.ButtonType.CLOSE
import javafx.scene.control.ButtonType.FINISH
import javafx.scene.control.ButtonType.NEXT
import javafx.scene.control.ButtonType.NO
import javafx.scene.control.ButtonType.OK
import javafx.scene.control.ButtonType.PREVIOUS
import javafx.scene.control.ButtonType.YES
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotfx.stage.icon
import kotlin.DeprecationLevel.ERROR

/** Removes old icons and set a new one to this dialog. */
inline var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        (dialogPane.scene.window as Stage).icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
inline var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
inline var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

inline fun Dialog<*>.applyButton(noinline init: (Node.() -> Unit)? = null) = addButton(APPLY, init)
inline fun Dialog<*>.okButton(noinline init: (Node.() -> Unit)? = null) = addButton(OK, init)
inline fun Dialog<*>.cancelButton(noinline init: (Node.() -> Unit)? = null) = addButton(CANCEL, init)
inline fun Dialog<*>.closeButton(noinline init: (Node.() -> Unit)? = null) = addButton(CLOSE, init)
inline fun Dialog<*>.yesButton(noinline init: (Node.() -> Unit)? = null) = addButton(YES, init)
inline fun Dialog<*>.noButton(noinline init: (Node.() -> Unit)? = null) = addButton(NO, init)
inline fun Dialog<*>.finishButton(noinline init: (Node.() -> Unit)? = null) = addButton(FINISH, init)
inline fun Dialog<*>.nextButton(noinline init: (Node.() -> Unit)? = null) = addButton(NEXT, init)
inline fun Dialog<*>.previousButton(noinline init: (Node.() -> Unit)? = null) = addButton(PREVIOUS, init)
inline fun Dialog<*>.customButton(
    text: String,
    data: ButtonData = OTHER,
    noinline init: (Node.() -> Unit)? = null
) = addButton(ButtonType(text, data), init)

@PublishedApi
internal fun Dialog<*>.addButton(button: ButtonType, init: (Node.() -> Unit)?) {
    dialogPane.buttonTypes += button
    if (init != null) dialogPane.lookupButton(button).init()
}

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