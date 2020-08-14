@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TextField.setOnAction
 */
inline fun TextField.onAction(noinline action: (ActionEvent) -> Unit): Unit = setOnAction(action)
