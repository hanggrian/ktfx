@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.collections.MapChangeListener
import javafx.collections.MapChangeListener.Change
import javafx.collections.ObservableMap
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Add a listener to this observable map. */
fun <K, V> ObservableMap<K, V>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Change<out K, out V>) -> Unit
): MapChangeListener<K, V> = MapChangeListener<K, V> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }
