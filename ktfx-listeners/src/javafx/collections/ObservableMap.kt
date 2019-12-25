@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.collections.MapChangeListener
import javafx.collections.MapChangeListener.Change
import javafx.collections.ObservableMap

/** Add a listener to this observable map. */
inline fun <K, V> ObservableMap<K, V>.listener(
    noinline listener: (Change<out K, out V>) -> Unit
): MapChangeListener<K, V> = MapChangeListener<K, V>(listener).also { addListener(it) }
