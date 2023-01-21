@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDecorator
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXDecorator.setOnCloseButtonAction
 */
public inline fun JFXDecorator.onCloseButtonAction(noinline action: () -> Unit): Unit =
        setOnCloseButtonAction(action)
