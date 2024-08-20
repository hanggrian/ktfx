@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)

package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.Scene
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event filter to this scene. */
public fun <E : Event> Scene.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventFilter(type, it) }

/** Registers an event handler to this scene. */
public fun <E : Event> Scene.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventHandler(type, it) }

/** Takes a snapshot of this scene at the next frame and calls the specified callback method when the image is ready. */
public fun Scene.capture(
    context: CoroutineContext = Dispatchers.JavaFx,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit,
): Unit =
    snapshot({ param ->
        GlobalScope.launch(context) { callback(param) }
        null
    }, image)
