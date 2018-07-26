package javafxx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the handler that will be called when the user cancels */
fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

/** Sets the handler that will be called when the user has completed their editing. */
fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

/** Sets the handler that will be called when the user begins an edit. */
fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [ListView.scrollTo]. */
fun ListView<*>.onScrollTo(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }