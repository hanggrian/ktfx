@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.stage.Window
import javafx.stage.WindowEvent

/** Registers an event filter to this node. */
inline fun <E : Event> Window.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
inline fun <E : Event> Window.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** Called when there is an external request to close this [Window]. */
inline fun Window.onCloseRequest(
    noinline action: (WindowEvent) -> Unit
): Unit = setOnCloseRequest(action)

/** Called just prior to the [Window] being shown. */
inline fun Window.onShowing(
    noinline action: (WindowEvent) -> Unit
): Unit = setOnShowing(action)

/** Called just after the Window is shown. */
inline fun Window.onShown(
    noinline action: (WindowEvent) -> Unit
): Unit = setOnShown(action)

/** Called just prior to the [Window] being hidden. */
inline fun Window.onHiding(
    noinline action: (WindowEvent) -> Unit
): Unit = setOnHiding(action)

/** Called just after the [Window] has been hidden. */
inline fun Window.onHidden(
    noinline action: (WindowEvent) -> Unit
): Unit = setOnHidden(action)
