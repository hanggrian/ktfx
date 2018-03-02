@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray

inline fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    noinline listener: (array: T, changed: Boolean, from: Int, to: Int) -> Unit
) = addListener(ArrayChangeListener(listener))