@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TableColumnBase

/** Registers an event handler to this table column. */
inline fun <E : Event> TableColumnBase<*, *>.eventHandler(
    type: EventType<E>,
    noinline action: (Event) -> Unit
): EventHandler<E> = EventHandler<E>(action)
    .also { addEventHandler(type, it) }
