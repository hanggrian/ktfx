@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.MenuItem

/** Registers an event handler to this [MenuItem]. */
inline fun <E : Event> MenuItem.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** The action, which is invoked whenever the [MenuItem] is fired. */
inline fun MenuItem.onAction(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnAction(action)

/** The event handler that is associated with invocation of an accelerator for a [MenuItem]. */
inline fun MenuItem.onMenuValidation(
    noinline action: (Event) -> Unit
): Unit = setOnMenuValidation(action)
