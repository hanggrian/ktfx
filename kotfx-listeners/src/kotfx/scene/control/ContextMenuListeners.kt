@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.ContextMenu

inline fun ContextMenu.onAction(noinline action: (ActionEvent) -> Unit) = setOnAction(EventHandler(action))