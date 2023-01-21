@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun JFXDialog.onDialogClosed(noinline action: (JFXDialogEvent) -> Unit): Unit =
        setOnDialogClosed(action)

/**
 * @see JFXDialog.setOnDialogOpened
 */
public inline fun JFXDialog.onDialogOpened(noinline action: (JFXDialogEvent) -> Unit): Unit =
        setOnDialogOpened(action)
