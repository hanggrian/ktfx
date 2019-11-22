@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.stage.PopupWindow

/** Specifies whether the PopupWindow should be hidden when an unhandled escape key is pressed while the popup has focus. */
inline fun PopupWindow.onAutoHide(
    noinline action: (Event) -> Unit
): Unit = setOnAutoHide { event -> action(event) }
