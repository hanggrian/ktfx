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
var Dialog<*>.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    inline set(value) {
        dialogPane.scene.stage.icon = value
    }

/** Apply [ImageView] as graphic and icon of this dialog. */
var Dialog<*>.graphicIcon: ImageView
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        graphic = value; icon = value.image
    }

/** Apply string as header text and title of this dialog. */
var Dialog<*>.headerTitle: String
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) {
        headerText = value; title = value
    }

/** Quickly add button type to this dialog without DSL. */
val Dialog<*>.buttons: DialogButtonContainer get() = DialogButtonContainer(this)

/** Opens up DSL to add button types to this dialog. */
fun Dialog<*>.buttons(dialogButtonConfiguration: DialogButtonContainerScope.() -> Unit) {
    contract { callsInPlace(dialogButtonConfiguration, InvocationKind.EXACTLY_ONCE) }
    DialogButtonContainerScope(this).dialogButtonConfiguration()
}

/** Supporting class to build dialog buttons with Kotlin DSL. */
open class DialogButtonContainer internal constructor(private val nativeDialog: Dialog<*>) {

    /** Add apply button. */
    fun apply(): Button = add(ButtonType.APPLY)

    /** Add apply button, invoking DSL to customize it as node. */
    inline fun apply(configuration: Button.() -> Unit): Button = apply().apply(configuration)

    /** Add ok button. */
    fun ok(): Button = add(ButtonType.OK)

    /** Add ok button, invoking DSL to customize it as node. */
    inline fun ok(configuration: Button.() -> Unit): Button = ok().apply(configuration)

    /** Add cancel button. */
    fun cancel(): Button = add(ButtonType.CANCEL)

    /** Add cancel button, invoking DSL to customize it as node. */
    inline fun cancel(configuration: Button.() -> Unit): Button = cancel().apply(configuration)

    /** Add close button. */
    fun close(): Button = add(ButtonType.CLOSE)

    /** Add close button, invoking DSL to customize it as node. */
    inline fun close(configuration: Button.() -> Unit): Button = close().apply(configuration)

    /** Add yes button. */
    fun yes(): Button = add(ButtonType.YES)

    /** Add yes button, invoking DSL to customize it as node. */
    inline fun yes(configuration: Button.() -> Unit): Button = yes().apply(configuration)

    /** Add no button. */
    fun no(): Button = add(ButtonType.NO)

    /** Add no button, invoking DSL to customize it as node. */
    inline fun no(configuration: Button.() -> Unit): Button = no().apply(configuration)

    /** Add finish button. */
    fun finish(): Button = add(ButtonType.FINISH)

    /** Add finish button, invoking DSL to customize it as node. */
    inline fun finish(configuration: Button.() -> Unit): Button = finish().apply(configuration)

    /** Add next button. */
    fun next(): Button = add(ButtonType.NEXT)

    /** Add next button, invoking DSL to customize it as node. */
    inline fun next(configuration: Button.() -> Unit): Button = next().apply(configuration)

    /** Add previous button. */
    fun previous(): Button = add(ButtonType.PREVIOUS)

    /** Add previous button, invoking DSL to customize it as node. */
    inline fun previous(configuration: Button.() -> Unit): Button = previous().apply(configuration)

    /** Add custom button specifying text and type. */
    fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER
    ): Button = add(ButtonType(text, data))

    /** Add custom button specifying text and type, invoking DSL to customize it as node. */
    inline fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        configuration: Button.() -> Unit
    ): Button = custom(text, data).apply(configuration)

    private fun add(type: ButtonType): Button {
        nativeDialog.dialogPane.buttonTypes += type
        return nativeDialog.dialogPane.lookupButton(type) as Button
    }
}

/** Scope of [DialogButtonContainer]. */
class DialogButtonContainerScope internal constructor(nativeDialog: Dialog<*>) : DialogButtonContainer(nativeDialog) {

    /** Alias of [custom] with operator function. */
    inline operator fun String.invoke(
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        configuration: Button.() -> Unit
    ): Button = custom(this, data, configuration)
}
