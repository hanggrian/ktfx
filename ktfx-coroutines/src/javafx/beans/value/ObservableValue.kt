@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit
): ChangeListener<T> = ChangeListener<T> { observable, oldValue, newValue ->
    GlobalScope.launch(context) { listener(observable, oldValue, newValue) }
}.also { addListener(it) }
