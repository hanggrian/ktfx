@file:JvmMultifileClass
@file:JvmName("ControlsFxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.listeners

import javafx.event.Event
import org.controlsfx.control.NotificationPane

/** Called just prior to the [NotificationPane] being shown. */
inline fun NotificationPane.onShowing(
    noinline action: (Event) -> Unit
): Unit = setOnShowing { event -> action(event) }

/** Called just after the [NotificationPane] is shown. */
inline fun NotificationPane.onShown(
    noinline action: (Event) -> Unit
): Unit = setOnShown { event -> action(event) }

/** Called just prior to the [NotificationPane] being hidden. */
inline fun NotificationPane.onHiding(
    noinline action: (Event) -> Unit
): Unit = setOnHiding { event -> action(event) }

/** Called just after the [NotificationPane] has been hidden. */
inline fun NotificationPane.onHidden(
    noinline action: (Event) -> Unit
): Unit = setOnHidden { event -> action(event) }
