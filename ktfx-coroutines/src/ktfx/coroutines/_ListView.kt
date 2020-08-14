@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

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
fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditStart { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see ListView.setOnEditCommit
 */
fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCommit { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see ListView.setOnEditCancel
 */
fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCancel { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see ListView.setOnScrollTo
 */
fun <T> ListView<T>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event ->
    GlobalScope.launch(context) { action(event) }
}
