@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.dialogs

import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import ktfx.controls.icon
import ktfx.controls.stage
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

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
    inline fun apply(block: Button.() -> Unit): Button = apply().apply(block)

    /** Add ok button. */
    fun ok(): Button = add(ButtonType.OK)

    /** Add ok button, invoking DSL to customize it as node. */
    inline fun ok(block: Button.() -> Unit): Button = ok().apply(block)

    /** Add cancel button. */
    fun cancel(): Button = add(ButtonType.CANCEL)

    /** Add cancel button, invoking DSL to customize it as node. */
    inline fun cancel(block: Button.() -> Unit): Button = cancel().apply(block)

    /** Add close button. */
    fun close(): Button = add(ButtonType.CLOSE)

    /** Add close button, invoking DSL to customize it as node. */
    inline fun close(block: Button.() -> Unit): Button = close().apply(block)

    /** Add yes button. */
    fun yes(): Button = add(ButtonType.YES)

    /** Add yes button, invoking DSL to customize it as node. */
    inline fun yes(block: Button.() -> Unit): Button = yes().apply(block)

    /** Add no button. */
    fun no(): Button = add(ButtonType.NO)

    /** Add no button, invoking DSL to customize it as node. */
    inline fun no(block: Button.() -> Unit): Button = no().apply(block)

    /** Add finish button. */
    fun finish(): Button = add(ButtonType.FINISH)

    /** Add finish button, invoking DSL to customize it as node. */
    inline fun finish(block: Button.() -> Unit): Button = finish().apply(block)

    /** Add next button. */
    fun next(): Button = add(ButtonType.NEXT)

    /** Add next button, invoking DSL to customize it as node. */
    inline fun next(block: Button.() -> Unit): Button = next().apply(block)

    /** Add previous button. */
    fun previous(): Button = add(ButtonType.PREVIOUS)

    /** Add previous button, invoking DSL to customize it as node. */
    inline fun previous(block: Button.() -> Unit): Button = previous().apply(block)

    /** Add custom button specifying text and type. */
    fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER
    ): Button = add(ButtonType(text, data))

    /** Add custom button specifying text and type, invoking DSL to customize it as node. */
    inline fun custom(
        text: String,
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        block: Button.() -> Unit
    ): Button = custom(text, data).apply(block)

    private fun add(type: ButtonType): Button = nativeDialog.dialogPane.run {
        buttonTypes += type
        return lookupButton(type) as Button
    }
}

class DialogButtonContainerScope internal constructor(nativeDialog: Dialog<*>) : DialogButtonContainer(nativeDialog) {

    /** Alias of [custom] with operator function. */
    inline operator fun String.invoke(
        data: ButtonBar.ButtonData = ButtonBar.ButtonData.OTHER,
        block: Button.() -> Unit
    ): Button = custom(this, data, block)
}