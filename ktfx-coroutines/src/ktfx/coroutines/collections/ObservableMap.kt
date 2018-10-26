@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.collections.MapChangeListener
import javafx.collections.MapChangeListener.Change
import javafx.collections.ObservableMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Add a listener to this observable map. */
fun <K, V> ObservableMap<K, V>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out K, out V>) -> Unit
): MapChangeListener<K, V> = MapChangeListener<K, V> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }