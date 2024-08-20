@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:OptIn(DelicateCoroutinesApi::class)

package ktfx.coroutines

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Add a listener to this observable map. */
public fun <E> ObservableSet<E>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend CoroutineScope.(SetChangeListener.Change<out E>) -> Unit,
): SetChangeListener<E> =
    SetChangeListener<E> { change ->
        GlobalScope.launch(context) { listener(change) }
    }.also { addListener(it) }
