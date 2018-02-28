@file:Suppress("NOTHING_TO_INLINE")

package kotfx.transform

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.transform.Transform

inline fun <E : Event> Transform.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Transform.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))