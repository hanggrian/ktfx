@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.Event
import javafx.stage.PopupWindow
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see PopupWindow.setOnAutoHide
 */
inline fun PopupWindow.onAutoHide(noinline action: (Event) -> Unit): Unit = setOnAutoHide(action)
