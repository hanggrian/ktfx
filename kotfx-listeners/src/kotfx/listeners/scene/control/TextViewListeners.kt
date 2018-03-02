@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.TextField

inline fun TextField.onAction(noinline action: (ActionEvent) -> Unit) = setOnAction(EventHandler(action))