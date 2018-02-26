@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.transform.Transform

inline fun <E : Event> Transform.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <E : Event> Transform.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }