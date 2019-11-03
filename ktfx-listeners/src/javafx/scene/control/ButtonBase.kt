@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase

/** The button's action, which is invoked whenever the button is fired. */
inline fun ButtonBase.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction { event -> action(event) }
