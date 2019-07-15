@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
fun Observable.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Observable) -> Unit
): InvalidationListener = InvalidationListener { observable ->
    GlobalScope.launch(context) { listener(observable) }
}.also { addListener(it) }
