@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ComboBoxBase.setOnAction
 */
inline fun ComboBoxBase<*>.onAction(noinline action: (ActionEvent) -> Unit): Unit =
    setOnAction(action)

/**
 * @see ComboBoxBase.setOnShowing
 */
inline fun ComboBoxBase<*>.onShowing(noinline action: (Event) -> Unit): Unit = setOnShowing(action)

/**
 * @see ComboBoxBase.setOnShown
 */
inline fun ComboBoxBase<*>.onShown(noinline action: (Event) -> Unit): Unit = setOnShown(action)

/**
 * @see ComboBoxBase.setOnHiding
 */
inline fun ComboBoxBase<*>.onHiding(noinline action: (Event) -> Unit): Unit = setOnHiding(action)

/**
 * @see ComboBoxBase.setOnHidden
 */
inline fun ComboBoxBase<*>.onHidden(noinline action: (Event) -> Unit): Unit = setOnHidden(action)
