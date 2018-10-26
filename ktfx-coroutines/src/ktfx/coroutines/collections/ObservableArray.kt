@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Add a listener to this observable array. */
fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    context: kotlin.coroutines.CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (array: T, changed: Boolean, from: Int, to: Int) -> Unit
): ArrayChangeListener<T> = ArrayChangeListener<T> { array, changed, from, to ->
    GlobalScope.launch(context) { listener(array, changed, from, to) }
}.also { addListener(it) }