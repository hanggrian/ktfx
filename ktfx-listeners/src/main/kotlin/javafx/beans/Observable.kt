@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.beans.InvalidationListener
import javafx.beans.Observable

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
inline fun Observable.listener(
    noinline listener: (Observable) -> Unit
): InvalidationListener = InvalidationListener(listener).also { addListener(it) }
