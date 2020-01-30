@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent

/** Registers an event filter to this transform. */
inline fun <E : Event> Transform.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this transform. */
inline fun <E : Event> Transform.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** Sets the onTransformChanged event handler which is called whenever the transform changes any of its parameters. */
inline fun Transform.onTransformChanged(
    noinline action: (TransformChangedEvent) -> Unit
): Unit = setOnTransformChanged(action)
