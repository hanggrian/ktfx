@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.Tab

inline fun Tab.onClosed(noinline action: (Event) -> Unit) = setOnClosed(EventHandler(action))

inline fun Tab.onCloseRequest(noinline action: (Event) -> Unit) = setOnCloseRequest(EventHandler(action))

inline fun Tab.onSelectionChanged(noinline action: (Event) -> Unit) = setOnSelectionChanged(EventHandler(action))