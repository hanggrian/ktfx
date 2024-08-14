@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
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
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import ktfx.windows.icon
import ktfx.windows.stage
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Removes old icons and set a new one to this dialog. */
public var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        dialogPane.scene.stage.icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
public var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
public var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Returns button configurator of this [Dialog]. */
public inline val Dialog<*>.buttons: DialogButtonContainer get() = DialogButtonContainer(this)

/**
 * Configure [Dialog] buttons.
 *
 * @param configuration the configuration block.
 */
public inline fun Dialog<*>.buttons(configuration: DialogButtonContainerScope.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    DialogButtonContainerScope(this).configuration()
}

/** Container of [ButtonType], providing sets of useful operation. */
public open class DialogButtonContainer(private val nativeDialog: Dialog<*>) {
    /** Add apply button using [configuration] block. */
    public inline fun apply(configuration: Button.() -> Unit): Button =
        add(APPLY).apply(configuration)

    /** Add ok button using [configuration] block. */
    public inline fun ok(configuration: Button.() -> Unit): Button = add(OK).apply(configuration)

    /** Add cancel button using [configuration] block. */
    public inline fun cancel(configuration: Button.() -> Unit): Button =
        add(CANCEL).apply(configuration)

    /** Add close button using [configuration] block. */
    public inline fun close(configuration: Button.() -> Unit): Button =
        add(CLOSE).apply(configuration)

    /** Add yes button using [configuration] block. */
    public inline fun yes(configuration: Button.() -> Unit): Button = add(YES).apply(configuration)

    /** Add no button using [configuration] block. */
    public inline fun no(configuration: Button.() -> Unit): Button = add(NO).apply(configuration)

    /** Add finish button using [configuration] block. */
    public inline fun finish(configuration: Button.() -> Unit): Button =
        add(FINISH).apply(configuration)

    /** Add next button using [configuration] block. */
    public inline fun next(configuration: Button.() -> Unit): Button =
        add(NEXT).apply(configuration)

    /** Add previous button using [configuration] block. */
    public inline fun previous(configuration: Button.() -> Unit): Button =
        add(PREVIOUS).apply(configuration)

    /** Add custom button specifying [text] and [data]. */
    public inline fun add(text: String, data: ButtonBar.ButtonData = OTHER): Button =
        add(ButtonType(text, data))

    /** Add custom button specifying [text] and [data] using [configuration] block. */
    public inline fun add(
        text: String,
        data: ButtonBar.ButtonData = OTHER,
        configuration: Button.() -> Unit,
    ): Button = add(text, data).apply(configuration)

    /** Add raw [ButtonType]. */
    public fun add(type: ButtonType): Button {
        nativeDialog.dialogPane.buttonTypes += type
        return nativeDialog.dialogPane.lookupButton(type) as Button
    }

    /** Add raw [ButtonType] using [configuration] block. */
    public fun add(type: ButtonType, configuration: Button.() -> Unit): Button =
        add(type).apply(configuration)

    /** Add raw [ButtonType] with Kotlin operator. */
    public operator fun plusAssign(type: ButtonType) {
        add(type)
    }
}

/** Receiver for `buttons` block. */
public class DialogButtonContainerScope(nativeDialog: Dialog<*>) :
    DialogButtonContainer(nativeDialog) {
    /** Alias of [add] with operator function. */
    public operator fun String.invoke(
        data: ButtonBar.ButtonData = OTHER,
        configuration: Button.() -> Unit,
    ): Button = add(this, data, configuration)
}
