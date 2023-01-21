@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
inline fun <T> ObservableValue<T>.listener(
    noinline listener: (Observable, oldValue: T, newValue: T) -> Unit
): ChangeListener<T> = ChangeListener<T>(listener).also { addListener(it) }
