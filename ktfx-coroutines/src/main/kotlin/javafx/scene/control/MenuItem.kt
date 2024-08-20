@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)

package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event handler to this [MenuItem]. */
public fun <E : Event> MenuItem.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit,
): EventHandler<E> =
    EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
        .also { addEventHandler(type, it) }
