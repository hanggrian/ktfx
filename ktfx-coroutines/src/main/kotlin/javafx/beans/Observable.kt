@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Adds an [InvalidationListener] which will be notified whenever the [Observable] becomes invalid. */
public fun Observable.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable) -> Unit,
): InvalidationListener =
    InvalidationListener { observable ->
        GlobalScope.launch(context) { listener(observable) }
    }.also { addListener(it) }
