@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event filter to this node. */
fun <E : Event> Node.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
fun <E : Event> Node.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventHandler(type, it) }

/** Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready. */
fun Node.capture(
    context: CoroutineContext = Dispatchers.JavaFx,
    image: WritableImage? = null,
    configuration: SnapshotParameters.() -> Unit = { },
    callback: suspend (SnapshotResult) -> Unit,
): Unit =
    snapshot(
        { param ->
            GlobalScope.launch(context) { callback(param) }
            null
        },
        SnapshotParameters().apply(configuration),
        image,
    )
