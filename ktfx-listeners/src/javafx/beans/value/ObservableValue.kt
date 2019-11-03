@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
inline fun <T> ObservableValue<T>.listener(
    noinline listener: (Observable, oldValue: T, value: T) -> Unit
): ChangeListener<T> = ChangeListener<T> { observable, oldValue, value ->
    listener(observable, oldValue, value)
}.also { addListener(it) }
