@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.collections.ListChangeListener
import javafx.collections.ListChangeListener.Change
import javafx.collections.ObservableList
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Add a listener to this observable list. */
fun <E> ObservableList<E>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out E>) -> Unit
): ListChangeListener<E> = ListChangeListener<E> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }
