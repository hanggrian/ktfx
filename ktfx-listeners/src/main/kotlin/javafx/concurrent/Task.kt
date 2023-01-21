@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.concurrent.Task
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType

/** Registers an event filter to this task. */
inline fun <E : Event> Task<*>.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this task. */
inline fun <E : Event> Task<*>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }
