@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.collections.MapChangeListener
import javafx.collections.MapChangeListener.Change
import javafx.collections.ObservableMap
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable map. */
fun <K, V> ObservableMap<K, V>.listener(
    context: CoroutineContext = FX,
    listener: suspend (Change<out K, out V>) -> Unit
): MapChangeListener<K, V> = MapChangeListener<K, V> { change ->
    launch(context) { listener(change) }
}.also { addListener(it) }