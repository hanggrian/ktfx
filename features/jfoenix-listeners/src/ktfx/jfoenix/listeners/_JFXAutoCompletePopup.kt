@file:JvmMultifileClass
@file:JvmName("JFoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXAutoCompletePopup.setSelectionHandler
 */
inline fun <T> JFXAutoCompletePopup<T>.selectionHandler(
    noinline
    action: (JFXAutoCompleteEvent<T>) -> Unit
) {
    return setSelectionHandler(action)
}
