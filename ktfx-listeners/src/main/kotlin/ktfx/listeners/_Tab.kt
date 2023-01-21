@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun Tab.onSelectionChanged(noinline action: (Event) -> Unit): Unit =
        setOnSelectionChanged(action)

/**
 * @see Tab.setOnClosed
 */
public inline fun Tab.onClosed(noinline action: (Event) -> Unit): Unit = setOnClosed(action)

/**
 * @see Tab.setOnCloseRequest
 */
public inline fun Tab.onCloseRequest(noinline action: (Event) -> Unit): Unit =
        setOnCloseRequest(action)
