package javafxx.coroutines

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import javafx.collections.SetChangeListener.Change
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable map. */
fun <E> ObservableSet<E>.listener(
    context: CoroutineContext = FX,
    listener: suspend (Change<out E>) -> Unit
): SetChangeListener<E> = SetChangeListener<E> { change ->
    launch(context) { listener(change) }
}.also { addListener(it) }