@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.jfoenix.listeners

import com.jfoenix.transitions.JFXAnimationTimer
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see JFXAnimationTimer.setOnFinished
 */
public inline fun JFXAnimationTimer.onFinished(noinline action: () -> Unit): Unit =
        setOnFinished(action)
