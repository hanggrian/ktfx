@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.Scene
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage

/** Registers an event filter to this scene. */
inline fun <E : Event> Scene.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this scene. */
inline fun <E : Event> Scene.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** Takes a snapshot of this scene at the next frame and calls the specified callback method when the image is ready. */
inline fun Scene.capture(
    image: WritableImage? = null,
    noinline callback: (SnapshotResult) -> Unit
): Unit = snapshot({ callback(it); null }, image)
