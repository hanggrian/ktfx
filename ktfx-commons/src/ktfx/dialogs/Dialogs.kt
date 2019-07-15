@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

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
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals
import ktfx.windows.icon
import ktfx.windows.stage

/** Removes old icons and set a new one to this dialog. */
inline var Dialog<*>.icon: Image
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        dialogPane.scene.stage.icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
inline var Dialog<*>.graphicIcon: ImageView
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
inline var Dialog<*>.headerTitle: String
    @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Add apply button, invoking DSL to customize it as node. */
inline fun Dialog<*>.applyButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(APPLY, init)

/** Add ok button, invoking DSL to customize it as node. */
inline fun Dialog<*>.okButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(OK, init)

/** Add cancel button, invoking DSL to customize it as node. */
inline fun Dialog<*>.cancelButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(CANCEL, init)

/** Add close button, invoking DSL to customize it as node. */
inline fun Dialog<*>.closeButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(CLOSE, init)

/** Add yes button, invoking DSL to customize it as node. */
inline fun Dialog<*>.yesButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(YES, init)

/** Add no button, invoking DSL to customize it as node. */
inline fun Dialog<*>.noButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(NO, init)

/** Add finish button, invoking DSL to customize it as node. */
inline fun Dialog<*>.finishButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(FINISH, init)

/** Add next button, invoking DSL to customize it as node. */
inline fun Dialog<*>.nextButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(NEXT, init)

/** Add previous button, invoking DSL to customize it as node. */
inline fun Dialog<*>.previousButton(noinline init: (Node.() -> Unit)? = null): Node = addButton(PREVIOUS, init)

/** Add custom button specifying text and type, invoking DSL to customize it as node. */
inline fun Dialog<*>.customButton(
    text: String,
    data: ButtonData = OTHER,
    noinline init: (Node.() -> Unit)? = null
): Node = addButton(ButtonType(text, data), init)

/** Invokes DSL to create a button in dialog, returning a Node. */
@PublishedApi
internal fun Dialog<*>.addButton(
    type: ButtonType,
    init: (Node.() -> Unit)?
): Node = dialogPane.run {
    buttonTypes += type
    return lookupButton(type).also { init?.invoke(it) }
}
