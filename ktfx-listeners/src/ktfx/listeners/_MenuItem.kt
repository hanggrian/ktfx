@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see MenuItem.setOnAction
 */
inline fun MenuItem.onAction(noinline action: (ActionEvent) -> Unit): Unit = setOnAction(action)

/**
 * @see MenuItem.setOnMenuValidation
 */
inline fun MenuItem.onMenuValidation(noinline action: (Event) -> Unit): Unit =
    setOnMenuValidation(action)
