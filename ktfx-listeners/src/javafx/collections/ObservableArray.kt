@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray

/** Add a listener to this observable array. */
inline fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    noinline listener: (array: T, changed: Boolean, from: Int, to: Int) -> Unit
): ArrayChangeListener<T> = ArrayChangeListener<T> { array, changed, from, to ->
    listener(array, changed, from, to)
}.also { addListener(it) }
