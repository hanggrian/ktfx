package ktfx.coroutines

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
fun Observable.listener(
    context: CoroutineContext = FX,
    listener: suspend (Observable) -> Unit
) = addListener { observable -> launch(context) { listener(observable) } }