@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType

@JvmOverloads
inline fun alert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(NONE, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun infoAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(INFORMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun warningAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(WARNING, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun errorAlert(
        contentText: String = "",
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(ERROR, contentText, *buttonTypes).apply {
    init?.invoke(this)
}