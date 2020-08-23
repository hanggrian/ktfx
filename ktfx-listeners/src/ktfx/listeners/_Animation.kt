@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Animation.setOnFinished
 */
inline fun Animation.onFinished(noinline action: (ActionEvent) -> Unit) {
    return setOnFinished(action)
}
