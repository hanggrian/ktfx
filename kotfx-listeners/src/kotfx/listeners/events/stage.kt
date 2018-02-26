@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventType
import javafx.stage.PopupWindow
import javafx.stage.Window
import javafx.stage.WindowEvent

inline fun PopupWindow.onAutoHide(
    noinline action: (Event) -> Unit
) = setOnAutoHide { event -> action(event) }

inline fun <E : Event> Window.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <E : Event> Window.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun Window.onCloseRequest(
    noinline action: (WindowEvent) -> Unit
) = setOnCloseRequest { event -> action(event) }

inline fun Window.onHidden(
    noinline action: (WindowEvent) -> Unit
) = setOnHidden { event -> action(event) }

inline fun Window.onHiding(
    noinline action: (WindowEvent) -> Unit
) = setOnHiding { event -> action(event) }

inline fun Window.onShowing(
    noinline action: (WindowEvent) -> Unit
) = setOnShowing { event -> action(event) }

inline fun Window.onShown(
    noinline action: (WindowEvent) -> Unit
) = setOnShown { event -> action(event) }