package javafxx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import javafx.scene.control.TreeView.EditEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the handler that will be called when the user cancels an edit. */
fun <T> TreeView<T>.onEditCancel(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

/** Sets the handler that will be called when the user commits an edit. */
fun <T> TreeView<T>.onEditCommit(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

/** Sets the handler that will be called when the user begins an edit. */
fun <T> TreeView<T>.onEditStart(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [TreeView.scrollTo]. */
fun TreeView<*>.onScrollTo(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }