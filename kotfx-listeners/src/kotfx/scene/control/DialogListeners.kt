@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent

inline fun <R> Dialog<R>.onCloseRequest(
    noinline action: (DialogEvent) -> Unit
) = setOnCloseRequest(EventHandler(action))

inline fun <R> Dialog<R>.onHidden(
    noinline action: (DialogEvent) -> Unit
) = setOnHidden(EventHandler(action))

inline fun <R> Dialog<R>.onHiding(
    noinline action: (DialogEvent) -> Unit
) = setOnHiding(EventHandler(action))

inline fun <R> Dialog<R>.onShowing(
    noinline action: (DialogEvent) -> Unit
) = setOnShowing(EventHandler(action))

inline fun <R> Dialog<R>.onShown(
    noinline action: (DialogEvent) -> Unit
) = setOnShown(EventHandler(action))