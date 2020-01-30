@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.Tab

/** Defines a function to be called when a selection changed has occurred on the [Tab]. */
inline fun Tab.onSelectionChanged(
    noinline action: (Event) -> Unit
): Unit = setOnSelectionChanged(action)

/** Defines a function to be called when the [Tab] is closed. */
inline fun Tab.onClosed(
    noinline action: (Event) -> Unit
): Unit = setOnClosed(action)

/** Called when there is an external request to close this [Tab]. */
inline fun Tab.onCloseRequest(
    noinline action: (Event) -> Unit
): Unit = setOnCloseRequest(action)
