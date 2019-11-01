@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.coroutines

import javafx.collections.MapChangeListener
import javafx.collections.MapChangeListener.Change
import javafx.collections.ObservableMap
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Add a listener to this observable map. */
fun <K, V> ObservableMap<K, V>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out K, out V>) -> Unit
): MapChangeListener<K, V> = MapChangeListener<K, V> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }
