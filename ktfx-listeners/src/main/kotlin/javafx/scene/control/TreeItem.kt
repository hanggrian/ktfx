@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TreeItem

/** Registers an event handler to this [TreeItem]. */
inline fun <E : Event> TreeItem<*>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler<E>(action)
    .also { addEventHandler(type, it) }
