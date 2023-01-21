@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.stage.Window

/** Registers an event filter to this node. */
inline fun <E : Event> Window.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
inline fun <E : Event> Window.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }
