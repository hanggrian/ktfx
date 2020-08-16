@file:JvmMultifileClass
@file:JvmName("JFoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXDialog.setOnDialogClosed
 */
inline fun JFXDialog.onDialogClosed(noinline action: (JFXDialogEvent) -> Unit) {
    return setOnDialogClosed(action)
}

/**
 * @see JFXDialog.setOnDialogOpened
 */
inline fun JFXDialog.onDialogOpened(noinline action: (JFXDialogEvent) -> Unit) {
    return setOnDialogOpened(action)
}
