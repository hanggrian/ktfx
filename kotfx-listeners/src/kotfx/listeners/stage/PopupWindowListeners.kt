@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.Event
import javafx.event.EventHandler
import javafx.stage.PopupWindow

inline fun PopupWindow.onAutoHide(
    noinline action: (Event) -> Unit
) = setOnAutoHide(EventHandler(action))