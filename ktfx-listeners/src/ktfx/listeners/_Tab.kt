@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.Tab
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Tab.setOnSelectionChanged
 */
inline fun Tab.onSelectionChanged(noinline action: (Event) -> Unit) {
    return setOnSelectionChanged(action)
}

/**
 * @see Tab.setOnClosed
 */
inline fun Tab.onClosed(noinline action: (Event) -> Unit) {
    return setOnClosed(action)
}

/**
 * @see Tab.setOnCloseRequest
 */
inline fun Tab.onCloseRequest(noinline action: (Event) -> Unit) {
    return setOnCloseRequest(action)
}
