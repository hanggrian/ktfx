@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import kotfx.internal.DialogDsl

class _Alert(type: Alert.AlertType, contentText: String, vararg buttonTypes: ButtonType) : Alert(type, contentText, *buttonTypes), _DialogBase<Alert> {
    override val dialog: Alert get() = this

    fun type(value: Alert.AlertType) = setAlertType(value)
}

@JvmOverloads
inline fun alertOf(
        type: Alert.AlertType,
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(type, contentText, *buttonTypes).apply {
    if (init != null) init()
}

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(NONE, contentText, *buttonTypes, init = init).apply { show() }

@JvmOverloads
inline fun alertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(NONE, contentText, *buttonTypes, init = init).apply { showAndWait() }

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(INFORMATION, contentText, *buttonTypes, init = init).apply { show() }

@JvmOverloads
inline fun infoAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(INFORMATION, contentText, *buttonTypes, init = init).apply { showAndWait() }

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(WARNING, contentText, *buttonTypes, init = init).apply { show() }

@JvmOverloads
inline fun warningAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(WARNING, contentText, *buttonTypes, init = init).apply { showAndWait() }

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(CONFIRMATION, contentText, *buttonTypes, init = init).apply { show() }

@JvmOverloads
inline fun confirmAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(CONFIRMATION, contentText, *buttonTypes, init = init).apply { showAndWait() }

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(ERROR, contentText, *buttonTypes, init = init).apply { show() }

@JvmOverloads
inline fun errorAlertWait(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = alertOf(ERROR, contentText, *buttonTypes, init = init).apply { showAndWait() }