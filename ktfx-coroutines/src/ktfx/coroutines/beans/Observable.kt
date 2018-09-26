@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
fun Observable.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Observable) -> Unit
): InvalidationListener = InvalidationListener { observable ->
    GlobalScope.launch(context) { listener(observable) }
}.also { addListener(it) }