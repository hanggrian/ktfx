@file:UseExperimental(ExperimentalContracts::class)

package ktfx.dialogs

import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.controls.icon
import ktfx.controls.stage
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/** Removes old icons and set a new one to this dialog. */
inline var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        dialogPane.scene.stage.icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Return buttons configurator of this [Dialog]. */
val Dialog<*>.buttons: DialogButtonContainer get() = DialogButtonContainer(this)

/** Configure buttons of this [Dialog] using [configuration] block. */
inline fun Dialog<*>.buttons(configuration: DialogButtonContainerScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    DialogButtonContainerScope(this).configuration()
}

/** Container of [ButtonType], providing sets of useful operation. */
open class DialogButtonContainer internal constructor(
    @PublishedApi internal val nativeDialog: Dialog<*>
) {

    /** Add apply button. */
    fun apply(): Button = add(ButtonType.APPLY)

    /** Add apply button using [configuration] block. */
    inline fun apply(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.APPLY)
        button.configuration()
        return button
    }

    /** Add ok button. */
    fun ok(): Button = add(ButtonType.OK)

    /** Add ok button using [configuration] block. */
    inline fun ok(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.OK)
        button.configuration()
        return button
    }

    /** Add cancel button. */
    fun cancel(): Button = add(ButtonType.CANCEL)

    /** Add cancel button using [configuration] block. */
    inline fun cancel(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.CANCEL)
        button.configuration()
        return button
    }

    /** Add close button. */
    fun close(): Button = add(ButtonType.CLOSE)

    /** Add close button using [configuration] block. */
    inline fun close(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.CLOSE)
        button.configuration()
        return button
    }

    /** Add yes button. */
    fun yes(): Button = add(ButtonType.YES)

    /** Add yes button using [configuration] block. */
    inline fun yes(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.YES)
        button.configuration()
        return button
    }

    /** Add no button. */
    fun no(): Button = add(ButtonType.NO)

    /** Add no button using [configuration] block. */
    inline fun no(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.NO)
        button.configuration()
        return button
    }

    /** Add finish button. */
    fun finish(): Button = add(ButtonType.FINISH)

    /** Add finish button using [configuration] block. */
    inline fun finish(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.FINISH)
        button.configuration()
        return button
    }

    /** Add next button. */
    fun next(): Button = add(ButtonType.NEXT)

    /** Add next button using [configuration] block. */
    inline fun next(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.NEXT)
        button.configuration()
        return button
    }

    /** Add previous button. */
    fun previous(): Button = add(ButtonType.PREVIOUS)

    /** Add previous button using [configuration] block. */
    inline fun previous(configuration: Button.() -> Unit): Button {
        val button = add(ButtonType.PREVIOUS)
        button.configuration()
        return button
    }

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
    ): Button {
        val button = add(ButtonType(text, data))
        button.configuration()
        return button
    }

    @PublishedApi internal fun add(type: ButtonType): Button {
        nativeDialog.dialogPane.buttonTypes += type
        return nativeDialog.dialogPane.lookupButton(type) as Button
    }
}

/** Receiver for `buttons` block. */
class DialogButtonContainerScope @PublishedApi internal constructor(nativeDialog: Dialog<*>) :
    DialogButtonContainer(nativeDialog) {

    /** Alias of [custom] with operator function. */
    inline operator fun String.invoke(
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        configuration: Button.() -> Unit
    ): Button = custom(this, data, configuration)
}
