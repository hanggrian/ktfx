@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent

inline fun Dialog<*>.onCloseRequest(noinline action: (DialogEvent) -> Unit) = setOnCloseRequest(EventHandler(action))

inline fun Dialog<*>.onHidden(noinline action: (DialogEvent) -> Unit) = setOnHidden(EventHandler(action))

inline fun Dialog<*>.onHiding(noinline action: (DialogEvent) -> Unit) = setOnHiding(EventHandler(action))

inline fun Dialog<*>.onShowing(noinline action: (DialogEvent) -> Unit) = setOnShowing(EventHandler(action))

inline fun Dialog<*>.onShown(noinline action: (DialogEvent) -> Unit) = setOnShown(EventHandler(action))