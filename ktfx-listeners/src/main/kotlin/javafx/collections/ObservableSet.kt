@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import javafx.collections.SetChangeListener.Change

/** Add a listener to this observable map. */
inline fun <E> ObservableSet<E>.listener(
    noinline listener: (Change<out E>) -> Unit
): SetChangeListener<E> = SetChangeListener<E>(listener).also { addListener(it) }
