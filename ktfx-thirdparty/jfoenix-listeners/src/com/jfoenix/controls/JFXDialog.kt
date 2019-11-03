@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.thirdparty.jfoenix.listeners

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent

inline fun JFXDialog.onDialogClosed(
    noinline action: (JFXDialogEvent) -> Unit
): Unit = setOnDialogClosed { event -> action(event) }

inline fun JFXDialog.onDialogOpened(
    noinline action: (JFXDialogEvent) -> Unit
): Unit = setOnDialogOpened { event -> action(event) }
