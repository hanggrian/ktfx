@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.beans.Observable
import javafx.beans.value.ObservableValue

inline fun <T> ObservableValue<T>.listener(
    noinline listener: (Observable, oldValue: T, value: T) -> Unit
) = addListener { observable, oldValue, value -> listener(observable, oldValue, value) }