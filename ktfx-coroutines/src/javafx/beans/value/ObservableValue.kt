@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit
): ChangeListener<T> = ChangeListener<T> { observable, oldValue, value ->
    GlobalScope.launch(context) { listener(observable, oldValue, value) }
}.also { addListener(it) }
