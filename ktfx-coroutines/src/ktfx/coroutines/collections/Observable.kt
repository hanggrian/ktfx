package ktfx.coroutines

import javafx.beans.Observable
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Observable.listener(
    context: CoroutineContext = FX,
    listener: suspend (Observable) -> Unit
) = addListener { observable -> launch(context) { listener(observable) } }