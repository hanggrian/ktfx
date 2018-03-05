package kotlinfx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun ListView<*>.onScrollTo(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }