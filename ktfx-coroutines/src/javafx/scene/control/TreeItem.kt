@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TreeItem
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Registers an event handler to this [TreeItem]. */
fun <E : Event> TreeItem<*>.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }
