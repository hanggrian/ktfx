@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage

/** Registers an event filter to this node. */
inline fun <E : Event> Node.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
inline fun <E : Event> Node.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready. */
inline fun Node.capture(
    image: WritableImage? = null,
    configuration: SnapshotParameters.() -> Unit = { },
    noinline callback: (SnapshotResult) -> Unit
): Unit = snapshot({ callback(it); null }, SnapshotParameters().apply(configuration), image)
