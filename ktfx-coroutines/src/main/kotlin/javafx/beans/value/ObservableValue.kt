@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)

package ktfx.coroutines

import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Adds a [ChangeListener] which will be notified whenever the value of the [ObservableValue] changes. */
public fun <T> ObservableValue<T>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(Observable, oldValue: T, value: T) -> Unit,
): ChangeListener<T> =
    ChangeListener { observable, oldValue, newValue ->
        GlobalScope.launch(context) { listener(observable, oldValue, newValue) }
    }.also { addListener(it) }
