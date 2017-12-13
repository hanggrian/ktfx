@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import kotfx.internal.DialogDsl

class _Alert(type: Alert.AlertType, contentText: String, vararg buttonTypes: ButtonType) : Alert(type, contentText, *buttonTypes), Dialoggable<Alert, ButtonType> {
    override val dialog: Alert get() = this
}

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(NONE, contentText, *buttonTypes).apply {
    if (init != null) init()
}

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(INFORMATION, contentText, *buttonTypes).apply {
    if (init != null) init()
}

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(WARNING, contentText, *buttonTypes).apply {
    if (init != null) init()
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    if (init != null) init()
}

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: ((@DialogDsl _Alert).() -> Unit)? = null
): Alert = _Alert(ERROR, contentText, *buttonTypes).apply {
    if (init != null) init()
}