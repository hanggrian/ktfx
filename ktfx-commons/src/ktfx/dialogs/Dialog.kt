package ktfx.dialogs

import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import ktfx.windows.icon
import ktfx.windows.stage
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Removes old icons and set a new one to this dialog. */
inline var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        dialogPane.scene.stage.icon = value
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

/** Returns button configurator of this [Dialog]. */
val Dialog<*>.buttons: DialogButtonContainer get() = DialogButtonContainer(this)

/**
 * Configure [Dialog] buttons.
 * @param configuration the configuration block.
 */
@OptIn(ExperimentalContracts::class)
fun Dialog<*>.buttons(configuration: DialogButtonContainerScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    DialogButtonContainerScope(this).configuration()
}

/** Container of [ButtonType], providing sets of useful operation. */
open class DialogButtonContainer internal constructor(private val nativeDialog: Dialog<*>) {

    /** Add apply button. */
    fun apply(): Button = add(ButtonType.APPLY)

    /** Add apply button using [configuration] block. */
    inline fun apply(configuration: Button.() -> Unit): Button = add(ButtonType.APPLY).apply(configuration)

    /** Add ok button. */
    fun ok(): Button = add(ButtonType.OK)

    /** Add ok button using [configuration] block. */
    inline fun ok(configuration: Button.() -> Unit): Button = add(ButtonType.OK).apply(configuration)

    /** Add cancel button. */
    fun cancel(): Button = add(ButtonType.CANCEL)

    /** Add cancel button using [configuration] block. */
    inline fun cancel(configuration: Button.() -> Unit): Button = add(ButtonType.CANCEL).apply(configuration)

    /** Add close button. */
    fun close(): Button = add(ButtonType.CLOSE)

    /** Add close button using [configuration] block. */
    inline fun close(configuration: Button.() -> Unit): Button = add(ButtonType.CLOSE).apply(configuration)

    /** Add yes button. */
    fun yes(): Button = add(ButtonType.YES)

    /** Add yes button using [configuration] block. */
    inline fun yes(configuration: Button.() -> Unit): Button = add(ButtonType.YES).apply(configuration)

    /** Add no button. */
    fun no(): Button = add(ButtonType.NO)

    /** Add no button using [configuration] block. */
    inline fun no(configuration: Button.() -> Unit): Button = add(ButtonType.NO).apply(configuration)

    /** Add finish button. */
    fun finish(): Button = add(ButtonType.FINISH)

    /** Add finish button using [configuration] block. */
    inline fun finish(configuration: Button.() -> Unit): Button = add(ButtonType.FINISH).apply(configuration)

    /** Add next button. */
    fun next(): Button = add(ButtonType.NEXT)

    /** Add next button using [configuration] block. */
    inline fun next(configuration: Button.() -> Unit): Button = add(ButtonType.NEXT).apply(configuration)

    /** Add previous button. */
    fun previous(): Button = add(ButtonType.PREVIOUS)

    /** Add previous button using [configuration] block. */
    inline fun previous(configuration: Button.() -> Unit): Button = add(ButtonType.PREVIOUS).apply(configuration)

    /** Add custom button specifying [text] and [data]. */
    fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER
    ): Button = add(ButtonType(text, data))

    /** Add custom button specifying [text] and [data] using [configuration] block. */
    inline fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        configuration: Button.() -> Unit
    ): Button = add(ButtonType(text, data)).apply(configuration)

    /** Add raw [ButtonType]. */
    fun add(type: ButtonType): Button {
        nativeDialog.dialogPane.buttonTypes += type
        return nativeDialog.dialogPane.lookupButton(type) as Button
    }

    /** Add raw [ButtonType] with Kotlin operator. */
    operator fun plusAssign(type: ButtonType) {
        add(type)
    }
}

/** Receiver for `buttons` block. */
class DialogButtonContainerScope internal constructor(nativeDialog: Dialog<*>) : DialogButtonContainer(nativeDialog) {

    /** Alias of [custom] with operator function. */
    inline operator fun String.invoke(
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        configuration: Button.() -> Unit
    ): Button = custom(this, data, configuration)
}
