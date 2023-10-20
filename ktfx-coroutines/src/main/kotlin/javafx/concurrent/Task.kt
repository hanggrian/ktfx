@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.concurrent.Task
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event filter to this task. */
fun <E : Event> Task<*>.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventFilter(type, it) }

/** Registers an event handler to this task. */
fun <E : Event> Task<*>.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventHandler(type, it) }
