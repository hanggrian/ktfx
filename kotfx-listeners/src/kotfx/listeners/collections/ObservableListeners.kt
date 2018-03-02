@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.beans.InvalidationListener
import javafx.beans.Observable

inline fun Observable.listener(
    noinline listener: (Observable) -> Unit
) = addListener(InvalidationListener(listener))