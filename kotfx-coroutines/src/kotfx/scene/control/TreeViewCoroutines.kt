package kotfx.scene.control

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> TreeView<T>.onEditCancel(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditCancel { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onEditCommit(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditCommit { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onEditStart(
    context: CoroutineContext,
    action: suspend CoroutineScope.(TreeView.EditEvent<T>) -> Unit
) = setOnEditStart { event -> launch(context) { action(event) } }

fun <T> TreeView<T>.onScrollTo(
    context: CoroutineContext,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
) = setOnScrollTo { event -> launch(context) { action(event) } }