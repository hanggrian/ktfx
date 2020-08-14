@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.Menu
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Menu.setOnShowing
 */
inline fun Menu.onShowing(noinline action: (Event) -> Unit): Unit = setOnShowing(action)

/**
 * @see Menu.setOnShown
 */
inline fun Menu.onShown(noinline action: (Event) -> Unit): Unit = setOnShown(action)

/**
 * @see Menu.setOnHiding
 */
inline fun Menu.onHiding(noinline action: (Event) -> Unit): Unit = setOnHiding(action)

/**
 * @see Menu.setOnHidden
 */
inline fun Menu.onHidden(noinline action: (Event) -> Unit): Unit = setOnHidden(action)
