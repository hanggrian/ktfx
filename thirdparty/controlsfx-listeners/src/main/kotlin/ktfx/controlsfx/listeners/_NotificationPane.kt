@file:JvmMultifileClass
@file:JvmName("ControlsfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.controlsfx.listeners

import javafx.event.Event
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import org.controlsfx.control.NotificationPane

/**
 * @see NotificationPane.setOnShowing
 */
public inline fun NotificationPane.onShowing(noinline action: (Event) -> Unit): Unit =
        setOnShowing(action)

/**
 * @see NotificationPane.setOnShown
 */
public inline fun NotificationPane.onShown(noinline action: (Event) -> Unit): Unit =
        setOnShown(action)

/**
 * @see NotificationPane.setOnHiding
 */
public inline fun NotificationPane.onHiding(noinline action: (Event) -> Unit): Unit =
        setOnHiding(action)

/**
 * @see NotificationPane.setOnHidden
 */
public inline fun NotificationPane.onHidden(noinline action: (Event) -> Unit): Unit =
        setOnHidden(action)
