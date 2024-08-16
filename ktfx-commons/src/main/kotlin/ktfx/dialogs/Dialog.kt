@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

import javafx.scene.control.Button
import javafx.scene.control.ButtonBar.ButtonData
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
public inline var Dialog<*>.icon: Image
    get() = dialogPane.scene.stage.icon
    set(value) {
        dialogPane.scene.stage.icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
public inline var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        graphic = value
        icon = value.image
    }

/** Apply string as header text and title of this dialog. */
public inline var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        headerText = value
        title = value
    }

/** Returns button configurator of this [Dialog]. */
public val Dialog<*>.buttons: DialogButtonContainer get() = DialogButtonContainer(this)

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
    public inline fun apply(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.APPLY).apply(configuration)
    }

    /** Add ok button using [configuration] block. */
    public inline fun ok(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.OK).apply(configuration)
    }

    /** Add cancel button using [configuration] block. */
    public inline fun cancel(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.CANCEL).apply(configuration)
    }

    /** Add close button using [configuration] block. */
    public inline fun close(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.CLOSE).apply(configuration)
    }

    /** Add yes button using [configuration] block. */
    public inline fun yes(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.YES).apply(configuration)
    }

    /** Add no button using [configuration] block. */
    public inline fun no(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.NO).apply(configuration)
    }

    /** Add finish button using [configuration] block. */
    public inline fun finish(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.FINISH).apply(configuration)
    }

    /** Add next button using [configuration] block. */
    public inline fun next(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.NEXT).apply(configuration)
    }

    /** Add previous button using [configuration] block. */
    public inline fun previous(configuration: Button.() -> Unit): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType.PREVIOUS).apply(configuration)
    }

    /** Add custom button specifying [text] and [data] using [configuration] block. */
    public inline fun add(
        text: String,
        data: ButtonData = ButtonData.OTHER,
        configuration: Button.() -> Unit,
    ): Button {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return add(ButtonType(text, data)).apply(configuration)
    }

    /** Add raw [ButtonType]. */
    public fun add(type: ButtonType): Button {
        nativeDialog.dialogPane.buttonTypes += type
        return nativeDialog.dialogPane.lookupButton(type) as Button
    }

    /** Add raw [ButtonType] with Kotlin operator. */
    public inline operator fun plusAssign(type: ButtonType) {
        add(type)
    }
}

/** Receiver for `buttons` block. */
public class DialogButtonContainerScope(nativeDialog: Dialog<*>) :
    DialogButtonContainer(nativeDialog) {
    /** Alias of [add] with operator function. */
    public inline operator fun String.invoke(
        data: ButtonData = ButtonData.OTHER,
        configuration: Button.() -> Unit,
    ): Button = add(this, data, configuration)
}
