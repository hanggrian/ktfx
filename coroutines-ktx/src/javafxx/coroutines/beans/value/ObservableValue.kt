@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = FX,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit
): ChangeListener<T> = ChangeListener<T> { observable, oldValue, value ->
    launch(context) { listener(observable, oldValue, value) }
}.also { addListener(it) }