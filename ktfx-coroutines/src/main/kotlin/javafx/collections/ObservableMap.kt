@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.collections.MapChangeListener
import javafx.collections.ObservableMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Add a listener to this observable map. */
fun <K, V> ObservableMap<K, V>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(MapChangeListener.Change<out K, out V>) -> Unit,
): MapChangeListener<K, V> =
    MapChangeListener<K, V> { change ->
        GlobalScope.launch(context) { listener(change) }
    }.also { addListener(it) }
