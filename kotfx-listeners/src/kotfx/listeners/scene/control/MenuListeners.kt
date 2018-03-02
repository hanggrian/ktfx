@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.Menu

inline fun <E : Event> Menu.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Menu.onHidden(noinline action: (Event) -> Unit) = setOnHidden(EventHandler(action))

inline fun Menu.onHiding(noinline action: (Event) -> Unit) = setOnHiding(EventHandler(action))

inline fun Menu.onShowing(noinline action: (Event) -> Unit) = setOnShowing(EventHandler(action))

inline fun Menu.onShown(noinline action: (Event) -> Unit) = setOnShown(EventHandler(action))