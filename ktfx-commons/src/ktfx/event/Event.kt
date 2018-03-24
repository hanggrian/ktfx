@file:Suppress("NOTHING_TO_INLINE")

package ktfx.event

import javafx.event.Event
import javafx.event.EventTarget
import javafx.event.EventType

/** The event target. */
inline operator fun Event.component1(): EventTarget = target

/** The event type. */
inline operator fun Event.component2(): EventType<out Event>? = eventType