@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
fun Observable.listener(
    context: CoroutineContext = FX,
    listener: suspend (Observable) -> Unit
): InvalidationListener = InvalidationListener { observable ->
    launch(context) { listener(observable) }
}.also { addListener(it) }