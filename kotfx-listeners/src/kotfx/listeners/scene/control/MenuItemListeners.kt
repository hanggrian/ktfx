@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.MenuItem

inline fun <E : Event> MenuItem.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun MenuItem.onAction(noinline action: (ActionEvent) -> Unit) = setOnAction(EventHandler(action))

inline fun MenuItem.onMenuValidation(noinline action: (Event) -> Unit) = setOnMenuValidation(EventHandler(action))