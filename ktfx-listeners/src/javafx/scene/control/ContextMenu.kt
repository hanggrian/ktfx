@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu

/** Callback function to be informed when an item contained within this [ContextMenu] has been activated. */
inline fun ContextMenu.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction(action)
