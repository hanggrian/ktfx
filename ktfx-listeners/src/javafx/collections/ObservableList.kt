@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.collections.ListChangeListener
import javafx.collections.ListChangeListener.Change
import javafx.collections.ObservableList

/** Add a listener to this observable list. */
inline fun <E> ObservableList<E>.listener(
    noinline listener: (Change<out E>) -> Unit
): ListChangeListener<E> = ListChangeListener<E>(listener).also { addListener(it) }
