@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import kotfx.internal.DialogDsl
import java.util.*

class _Alert(type: Alert.AlertType, contentText: String, vararg buttonTypes: ButtonType) : Alert(type, contentText, *buttonTypes), DialogBuilder<Alert> {
    override val dialog: Alert get() = this

    fun type(value: Alert.AlertType) = setAlertType(value)
}

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(NONE, contentText, *buttonTypes).apply {
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun alertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Optional<ButtonType> = _Alert(NONE, contentText, *buttonTypes).apply {
    init?.invoke(this)
}.showAndWait()

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(INFORMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun infoAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Optional<ButtonType> = _Alert(INFORMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}.showAndWait()

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(WARNING, contentText, *buttonTypes).apply {
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun warningAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Optional<ButtonType> = _Alert(WARNING, contentText, *buttonTypes).apply {
    init?.invoke(this)
}.showAndWait()

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun confirmAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Optional<ButtonType> = _Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}.showAndWait()

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(ERROR, contentText, *buttonTypes).apply {
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun errorAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Optional<ButtonType> = _Alert(ERROR, contentText, *buttonTypes).apply {
    init?.invoke(this)
}.showAndWait()