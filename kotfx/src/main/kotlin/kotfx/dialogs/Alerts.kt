@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.Alert.AlertType.*
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.image.Image

@JvmOverloads
inline fun alert(
        title: String,
        icon: Image? = null,
        noinline init: (AlertBuilder.() -> Unit)? = null
): Dialog<ButtonType> = FXAlertDialogBuilder(NONE).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun infoAlert(
        title: String,
        icon: Image? = null,
        noinline init: (AlertBuilder.() -> Unit)? = null
): Dialog<ButtonType> = FXAlertDialogBuilder(INFORMATION).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun warningAlert(
        title: String,
        icon: Image? = null,
        noinline init: (AlertBuilder.() -> Unit)? = null
): Dialog<ButtonType> = FXAlertDialogBuilder(WARNING).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun confirmAlert(
        title: String,
        icon: Image? = null,
        noinline init: (AlertBuilder.() -> Unit)? = null
): Dialog<ButtonType> = FXAlertDialogBuilder(CONFIRMATION).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t

@JvmOverloads
inline fun errorAlert(
        title: String,
        icon: Image? = null,
        noinline init: (AlertBuilder.() -> Unit)? = null
): Dialog<ButtonType> = FXAlertDialogBuilder(ERROR).apply {
    this.title = title
    if (icon != null) this.icon = icon
    if (init != null) init()
}.t