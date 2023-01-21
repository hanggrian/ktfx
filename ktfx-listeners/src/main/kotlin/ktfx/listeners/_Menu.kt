@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun Menu.onShowing(noinline action: (Event) -> Unit): Unit = setOnShowing(action)

/**
 * @see Menu.setOnShown
 */
public inline fun Menu.onShown(noinline action: (Event) -> Unit): Unit = setOnShown(action)

/**
 * @see Menu.setOnHiding
 */
public inline fun Menu.onHiding(noinline action: (Event) -> Unit): Unit = setOnHiding(action)

/**
 * @see Menu.setOnHidden
 */
public inline fun Menu.onHidden(noinline action: (Event) -> Unit): Unit = setOnHidden(action)
