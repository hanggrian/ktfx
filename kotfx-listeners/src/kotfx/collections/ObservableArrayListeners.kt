@file:Suppress("NOTHING_TO_INLINE")

package kotfx.collections

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray

inline fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    noinline listener: (array: T, changed: Boolean, from: Int, to: Int) -> Unit
) = addListener(ArrayChangeListener(listener))