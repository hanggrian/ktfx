@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TreeItem

inline fun <T, E : Event> TreeItem<T>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))