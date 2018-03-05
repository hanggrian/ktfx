package kotlinfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = FX,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit
) = addListener { observable, oldValue, value -> launch(context) { listener(observable, oldValue, value) } }