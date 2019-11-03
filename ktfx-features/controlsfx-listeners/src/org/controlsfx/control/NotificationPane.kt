@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import javafx.event.Event
import org.controlsfx.control.NotificationPane

inline fun NotificationPane.onShowing(
    noinline action: (Event) -> Unit
): Unit = setOnShowing { event -> action(event) }

inline fun NotificationPane.onShown(
    noinline action: (Event) -> Unit
): Unit = setOnShown { event -> action(event) }

inline fun NotificationPane.onHiding(
    noinline action: (Event) -> Unit
): Unit = setOnHiding { event -> action(event) }

inline fun NotificationPane.onHidden(
    noinline action: (Event) -> Unit
): Unit = setOnHidden { event -> action(event) }
