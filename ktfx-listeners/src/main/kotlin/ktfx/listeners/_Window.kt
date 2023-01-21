@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Window.setOnCloseRequest
 */
public inline fun Window.onCloseRequest(noinline action: (WindowEvent) -> Unit): Unit =
        setOnCloseRequest(action)

/**
 * @see Window.setOnShowing
 */
public inline fun Window.onShowing(noinline action: (WindowEvent) -> Unit): Unit =
        setOnShowing(action)

/**
 * @see Window.setOnShown
 */
public inline fun Window.onShown(noinline action: (WindowEvent) -> Unit): Unit = setOnShown(action)

/**
 * @see Window.setOnHiding
 */
public inline fun Window.onHiding(noinline action: (WindowEvent) -> Unit): Unit =
        setOnHiding(action)

/**
 * @see Window.setOnHidden
 */
public inline fun Window.onHidden(noinline action: (WindowEvent) -> Unit): Unit =
        setOnHidden(action)
