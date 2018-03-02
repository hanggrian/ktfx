@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.stage.Window
import javafx.stage.WindowEvent

inline fun <E : Event> Window.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Window.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Window.onCloseRequest(
    noinline action: (WindowEvent) -> Unit
) = setOnCloseRequest(EventHandler(action))

inline fun Window.onHidden(
    noinline action: (WindowEvent) -> Unit
) = setOnHidden(EventHandler(action))

inline fun Window.onHiding(
    noinline action: (WindowEvent) -> Unit
) = setOnHiding(EventHandler(action))

inline fun Window.onShowing(
    noinline action: (WindowEvent) -> Unit
) = setOnShowing(EventHandler(action))

inline fun Window.onShown(
    noinline action: (WindowEvent) -> Unit
) = setOnShown(EventHandler(action))