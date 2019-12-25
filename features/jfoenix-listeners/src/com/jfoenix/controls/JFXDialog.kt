@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent

/** Defines a function to be called when the dialog is closed. */
inline fun JFXDialog.onDialogClosed(
    noinline action: (JFXDialogEvent) -> Unit
): Unit = setOnDialogClosed { event -> action(event) }

/** Defines a function to be called when the dialog is opened. */
inline fun JFXDialog.onDialogOpened(
    noinline action: (JFXDialogEvent) -> Unit
): Unit = setOnDialogOpened { event -> action(event) }
