@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable array. */
fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (array: T, changed: Boolean, from: Int, to: Int) -> Unit
): ArrayChangeListener<T> = ArrayChangeListener<T> { array, changed, from, to ->
    GlobalScope.launch(context) { listener(array, changed, from, to) }
}.also { addListener(it) }