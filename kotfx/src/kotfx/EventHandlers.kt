@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.WeakEventHandler

inline fun <T : Event> EventHandler<T>.toWeakEventHandler() = WeakEventHandler(this)