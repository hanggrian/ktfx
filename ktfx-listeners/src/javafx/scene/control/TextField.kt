@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.TextField

/** The action handler associated with this text field, or `null` if no action handler is assigned. */
inline fun TextField.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction(action)
