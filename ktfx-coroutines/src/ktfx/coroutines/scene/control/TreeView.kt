@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import javafx.scene.control.TreeView.EditEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Sets the handler that will be called when the user cancels an edit. */
fun <T> TreeView<T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user commits an edit. */
fun <T> TreeView<T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user begins an edit. */
fun <T> TreeView<T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [TreeView.scrollTo]. */
fun TreeView<*>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }