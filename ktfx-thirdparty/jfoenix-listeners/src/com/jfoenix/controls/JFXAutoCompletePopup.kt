@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.thirdparty.jfoenix.listeners

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent

inline fun <T> JFXAutoCompletePopup<T>.selectionHandler(
    noinline action: (JFXAutoCompleteEvent<T>) -> Unit
): Unit = setSelectionHandler { event -> action(event) }
