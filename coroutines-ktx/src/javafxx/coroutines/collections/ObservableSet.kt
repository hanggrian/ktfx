@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import javafx.collections.SetChangeListener.Change
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable map. */
fun <E> ObservableSet<E>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out E>) -> Unit
): SetChangeListener<E> = SetChangeListener<E> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }