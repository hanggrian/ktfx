@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.Int
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see ListView.setOnEditStart
 */
public fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) {
    return setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see ListView.setOnEditCommit
 */
public fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) {
    return setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see ListView.setOnEditCancel
 */
public fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) {
    return setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see ListView.setOnScrollTo
 */
public fun <T> ListView<T>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) {
    return setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }
}
