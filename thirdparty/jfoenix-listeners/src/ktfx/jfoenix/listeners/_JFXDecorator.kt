@file:JvmMultifileClass
@file:JvmName("JFoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDecorator
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXDecorator.setOnCloseButtonAction
 */
inline fun JFXDecorator.onCloseButtonAction(noinline action: () -> Unit) {
    return setOnCloseButtonAction(action)
}
