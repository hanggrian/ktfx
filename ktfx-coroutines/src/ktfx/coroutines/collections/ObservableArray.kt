package ktfx.coroutines

import javafx.collections.ArrayChangeListener
import javafx.collections.ObservableArray
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Add a listener to this observable array. */
fun <T : ObservableArray<T>> ObservableArray<T>.listener(
    context: CoroutineContext = FX,
    listener: suspend (array: T, changed: Boolean, from: Int, to: Int) -> Unit
): ArrayChangeListener<T> = ArrayChangeListener<T> { array, changed, from, to ->
    launch(context) { listener(array, changed, from, to) }
}.also { addListener(it) }