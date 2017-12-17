@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import javafx.stage.Window

@JvmOverloads
inline fun alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(NONE, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.alert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(NONE, contentText, *buttonTypes).apply {
    initOwner(this@alert)
    init?.invoke(this)
}

@JvmOverloads
inline fun infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(INFORMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.infoAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(INFORMATION, contentText, *buttonTypes).apply {
    initOwner(this@infoAlert)
    init?.invoke(this)
}

@JvmOverloads
inline fun warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(WARNING, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.warningAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(WARNING, contentText, *buttonTypes).apply {
    initOwner(this@warningAlert)
    init?.invoke(this)
}

@JvmOverloads
inline fun confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.confirmAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(CONFIRMATION, contentText, *buttonTypes).apply {
    initOwner(this@confirmAlert)
    init?.invoke(this)
}

@JvmOverloads
inline fun errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(ERROR, contentText, *buttonTypes).apply {
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.errorAlert(
        contentText: String,
        vararg buttonTypes: ButtonType,
        noinline init: (Alert.() -> Unit)? = null
): Alert = Alert(ERROR, contentText, *buttonTypes).apply {
    initOwner(this@errorAlert)
    init?.invoke(this)
}