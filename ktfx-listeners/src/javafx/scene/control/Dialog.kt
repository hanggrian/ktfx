@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent

/** Called just prior to the [Dialog] being shown. */
inline fun Dialog<*>.onShowing(
    noinline action: (DialogEvent) -> Unit
): Unit = setOnShowing(action)

/** Called just after the [Dialog] is shown. */
inline fun Dialog<*>.onShown(
    noinline action: (DialogEvent) -> Unit
): Unit = setOnShown(action)

/** Called just prior to the [Dialog] being hidden. */
inline fun Dialog<*>.onHiding(
    noinline action: (DialogEvent) -> Unit
): Unit = setOnHiding(action)

/** Called just after the [Dialog] has been hidden. */
inline fun Dialog<*>.onHidden(
    noinline action: (DialogEvent) -> Unit
): Unit = setOnHidden(action)

/** Called when there is an external request to close this [Dialog]. */
inline fun Dialog<*>.onCloseRequest(
    noinline action: (DialogEvent) -> Unit
): Unit = setOnCloseRequest(action)
