@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Dialog.setOnShowing
 */
public inline fun Dialog<*>.onShowing(noinline action: (DialogEvent) -> Unit): Unit =
        setOnShowing(action)

/**
 * @see Dialog.setOnShown
 */
public inline fun Dialog<*>.onShown(noinline action: (DialogEvent) -> Unit): Unit =
        setOnShown(action)

/**
 * @see Dialog.setOnHiding
 */
public inline fun Dialog<*>.onHiding(noinline action: (DialogEvent) -> Unit): Unit =
        setOnHiding(action)

/**
 * @see Dialog.setOnHidden
 */
public inline fun Dialog<*>.onHidden(noinline action: (DialogEvent) -> Unit): Unit =
        setOnHidden(action)

/**
 * @see Dialog.setOnCloseRequest
 */
public inline fun Dialog<*>.onCloseRequest(noinline action: (DialogEvent) -> Unit): Unit =
        setOnCloseRequest(action)
