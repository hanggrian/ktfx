package kotfx.coroutines

import javafx.beans.Observable
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Observable.listener(
    context: CoroutineContext,
    listener: suspend (Observable) -> Unit
) = addListener { observable -> launch(context) { listener(observable) } }