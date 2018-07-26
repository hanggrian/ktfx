package javafxx.coroutines

import javafx.collections.ListChangeListener
import javafx.collections.ListChangeListener.Change
import javafx.collections.ObservableList
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable list. */
fun <E> ObservableList<E>.listener(
    context: CoroutineContext = FX,
    listener: suspend (Change<out E>) -> Unit
): ListChangeListener<E> = ListChangeListener<E> { change ->
    launch(context) { listener(change) }
}.also { addListener(it) }