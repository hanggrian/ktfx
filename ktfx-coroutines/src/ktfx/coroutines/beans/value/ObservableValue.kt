@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit
): ChangeListener<T> = ChangeListener<T> { observable, oldValue, value ->
    GlobalScope.launch(context) { listener(observable, oldValue, value) }
}.also { addListener(it) }